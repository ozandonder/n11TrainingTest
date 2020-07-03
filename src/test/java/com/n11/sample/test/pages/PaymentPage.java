package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BaseModel {

    public PaymentPage(WebDriver driver) {
        setDriver(driver);
    }

    public void cardForm(String cardNumber) {

        visibilityOfElementLocated(By.cssSelector("#js-goToPaymentBtn"));
        clickByCss("#js-goToPaymentBtn");
        visibilityOfElementLocated(By.cssSelector(".formfield.cardNumberField input:nth-child(3)"));
        setByCss(".formfield.cardNumberField input:nth-child(3)", "1234567890123456");
        setById("cardOwnerName", "ali can");
        selectByNameValue("paymentModel.creditCardModel.expireMonth", "2");
        selectByNameValue("paymentModel.creditCardModel.expireYear", "2022");
        setById("securityCode", "123");

    }

}
