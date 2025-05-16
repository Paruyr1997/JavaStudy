package com.mts.tests;

import com.mts.pages.MainPage;
import com.mts.pages.PaymentPage;
import utils.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Collections;

import io.qameta.allure.*;
import io.qameta.allure.model.Status;

@Epic("Онлайн платежи")
@Feature("Проверка функционала онлайн платежей")
public class OnlinePaymentTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(TestData.SITE_URL);

        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров для разных услуг")
    @Story("Пользователь проверяет плейсхолдеры для разных услуг")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что плейсхолдеры в полях ввода меняются в зависимости от выбранного типа услуги")
    void testPaymentOptionsPlaceholders() {
        Allure.step("Проверка услуг связи", () -> {
            mainPage.selectMobileServices();
            Assertions.assertEquals("Номер телефона", mainPage.getPhoneInputPlaceholder(),
                    "Неверный плейсхолдер для услуг связи");
        });

        Allure.step("Проверка домашнего интернета", () -> {
            mainPage.selectHomeInternet();
            Assertions.assertEquals("Номер договора", mainPage.getPhoneInputPlaceholder(),
                    "Неверный плейсхолдер для домашнего интернета");
        });
    }

    @Test
    @DisplayName("Проверка формы оплаты для услуг связи")
    @Story("Пользователь проверяет форму оплаты для услуг связи")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет корректность отображения формы оплаты для услуг мобильной связи")
    void testMobilePaymentForm() {
        Allure.step("Выбор услуг связи и ввод номера телефона", () -> {
            mainPage.selectMobileServices();
            mainPage.enterPhoneNumber(TestData.PHONE_NUMBER);
        });

        PaymentPage paymentPage = Allure.step("Переход на страницу оплаты", () -> {
            return mainPage.clickContinue();
        });

        Allure.step("Проверка отображения номера телефона", () -> {
            Assertions.assertTrue(paymentPage.getPhoneNumber().contains(TestData.PHONE_NUMBER),
                    "Номер телефона не соответствует введенному");
        });

        Allure.step("Проверка суммы платежа", () -> {
            Assertions.assertTrue(paymentPage.getAmount().matches(TestData.EXPECTED_AMOUNT_REGEX),
                    "Сумма платежа не соответствует ожидаемому формату");
        });

        Allure.step("Проверка кнопки оплаты", () -> {
            Assertions.assertTrue(paymentPage.getPayButtonText().matches(TestData.EXPECTED_AMOUNT_REGEX),
                    "Текст на кнопке оплаты не соответствует ожидаемому формату");
        });

        Allure.step("Проверка плейсхолдеров карты", () -> {
            Assertions.assertEquals("Номер карты", paymentPage.getCardNumberPlaceholder(),
                    "Неверный плейсхолдер для номера карты");
        });

        Allure.step("Проверка иконок платежных систем", () -> {
            Assertions.assertTrue(paymentPage.getPaymentSystemsCount() >= 3,
                    "Количество отображаемых платежных систем меньше ожидаемого");
        });
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}