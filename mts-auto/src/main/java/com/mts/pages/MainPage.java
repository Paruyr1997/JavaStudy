package com.mts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]")
    private WebElement paymentBlockTitle;

    @FindBy(xpath = "//label[contains(., 'Услуги связи')]")
    private WebElement mobileServicesOption;

    @FindBy(xpath = "//label[contains(., 'Домашний интернет')]")
    private WebElement homeInternetOption;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[contains(., 'Продолжить')]")
    private WebElement continueButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPaymentBlockTitle() {
        return paymentBlockTitle.getText();
    }

    public void selectMobileServices() {
        mobileServicesOption.click();
    }

    public void selectHomeInternet() {
        homeInternetOption.click();
    }

    public String getPhoneInputPlaceholder() {
        return phoneNumberInput.getAttribute("placeholder");
    }

    public void enterPhoneNumber(String phone) {
        phoneNumberInput.sendKeys(phone);
    }

    public PaymentPage clickContinue() {
        continueButton.click();
        return new PaymentPage(driver);
    }
}