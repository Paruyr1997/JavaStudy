package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

public class MtsByOnlinePaymentTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.chrome.silentOutput", "true");


        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
    }

    @Test
    void testBlockTitle() {
        try {
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]")));
            Assertions.assertEquals("Онлайн пополнение без комиссии", blockTitle.getText());
        } catch (Exception e) {
            takeScreenshot("block_title_error");
            throw e;
        }
    }

    @Test
    void testPaymentSystemLogos() {
        try {
            List<WebElement> paymentLogos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'payment-systems')]//img")));
            Assertions.assertTrue(paymentLogos.size() >= 3, "Должно быть не менее 3 логотипов");
        } catch (Exception e) {
            takeScreenshot("payment_logos_error");
            throw e;
        }
    }

    @Test
    void testDetailsLink() {
        try {
            String originalWindow = driver.getWindowHandle();
            WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(., 'Подробнее о сервисе')]")));
            detailsLink.click();

            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.equals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            Assertions.assertTrue(driver.getCurrentUrl().contains("mts.by"));
            driver.close();
            driver.switchTo().window(originalWindow);
        } catch (Exception e) {
            takeScreenshot("details_link_error");
            throw e;
        }
    }

    @Test
    void testPaymentForm() {
        try {
            WebElement serviceType = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[contains(., 'Услуги связи')]")));
            serviceType.click();

            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Номер телефона']")));
            phoneInput.sendKeys("297777777");

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Продолжить')]")));
            continueButton.click();

            WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Сумма']")));
            Assertions.assertTrue(amountInput.isDisplayed());
        } catch (Exception e) {
            takeScreenshot("payment_form_error");
            throw e;
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String name) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Не удалось сделать скриншот: " + e.getMessage());
        }
    }
}