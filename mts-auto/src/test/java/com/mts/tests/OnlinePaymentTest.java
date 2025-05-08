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
    void testPaymentOptionsPlaceholders() {
        // Проверка услуг связи
        mainPage.selectMobileServices();
        Assertions.assertEquals("Номер телефона", mainPage.getPhoneInputPlaceholder());

        // Проверка домашнего интернета
        mainPage.selectHomeInternet();
        Assertions.assertEquals("Номер договора", mainPage.getPhoneInputPlaceholder());
    }

    @Test
    @DisplayName("Проверка формы оплаты для услуг связи")
    void testMobilePaymentForm() {
        mainPage.selectMobileServices();
        mainPage.enterPhoneNumber(TestData.PHONE_NUMBER);

        PaymentPage paymentPage = mainPage.clickContinue();

        // Проверка отображения номера
        Assertions.assertTrue(paymentPage.getPhoneNumber().contains(TestData.PHONE_NUMBER));

        // Проверка суммы
        Assertions.assertTrue(paymentPage.getAmount().matches(TestData.EXPECTED_AMOUNT_REGEX));

        // Проверка кнопки оплаты
        Assertions.assertTrue(paymentPage.getPayButtonText().matches(TestData.EXPECTED_AMOUNT_REGEX));

        // Проверка плейсхолдеров карты
        Assertions.assertEquals("Номер карты", paymentPage.getCardNumberPlaceholder());

        // Проверка иконок платежных систем
        Assertions.assertTrue(paymentPage.getPaymentSystemsCount() >= 3);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}