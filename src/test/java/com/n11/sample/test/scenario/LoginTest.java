package com.n11.sample.test.scenario;

import com.n11.sample.test.base.BaseModel;
import com.n11.sample.test.pages.Browser;
import org.junit.Test;
import com.n11.sample.test.pages.LoginPage;
import org.openqa.selenium.By;

public class LoginTest extends BaseModel {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginP = new LoginPage(this.driver);
        Browser browser = new Browser(this.driver);

        browser.openBrowser("https://www.n11.com/");
        if (!driver.findElements(By.cssSelector(".closeBtn")).isEmpty()) {
            clickByCss(".closeBtn");
        }

        loginP.login("acan98529@gmail.com","test123");
    }

}