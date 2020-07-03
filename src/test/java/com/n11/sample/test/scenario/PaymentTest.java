package com.n11.sample.test.scenario;

import com.n11.sample.test.base.BaseModel;
import com.n11.sample.test.pages.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class PaymentTest extends BaseModel {


    @Test
    public void paymentTest() throws InterruptedException {

        LoginPage loginP = new LoginPage(this.driver);
        Browser browser = new Browser(this.driver);
        AddToBasket addToBasketPage = new AddToBasket(this.driver);
        CreateNewShippingAddress createNewShippingAddressPage = new CreateNewShippingAddress(this.driver);
        PaymentPage paymentTestPage = new PaymentPage(this.driver);

        browser.openBrowser("https://www.n11.com/");

        if (!driver.findElements(By.cssSelector(".closeBtn")).isEmpty()) {
            clickByCss(".closeBtn");
        }

        loginP.login("acan98529@gmail.com", "test123");

        addToBasketPage.addToBasket();

        createNewShippingAddressPage.createNewShippingAddress("Ali Can", "depo");

        Thread.sleep(2000);

        paymentTestPage.cardForm("1234567890123456");
        Thread.sleep(5000);


    }


}