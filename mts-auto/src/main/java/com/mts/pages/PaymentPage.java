package com.mts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PaymentPage {
    private final WebDriver driver;

    @FindBy(css = ".payment-amount")
    private WebElement amountElement;

    @FindBy(css = ".phone-number")
    private WebElement phoneNumberElement;

    @FindBy(xpath = "//input[@placeholder='Номер карты']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder='Срок действия']")
    private WebElement cardExpiryInput;

    @FindBy(css = ".payment-systems img")
    private List<WebElement> paymentSystemIcons;

    @FindBy(css = ".pay-button")
    private WebElement payButton;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAmount() {
        return amountElement.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberElement.getText();
    }

    public String getCardNumberPlaceholder() {
        return cardNumberInput.getAttribute("placeholder");
    }

    public int getPaymentSystemsCount() {
        return paymentSystemIcons.size();
    }

    public String getPayButtonText() {
        return payButton.getText();
    }
}