package com.n11.sample.test.scenario;

import com.n11.sample.test.base.BaseModel;
import com.n11.sample.test.pages.LoginPage;
import com.n11.sample.test.pages.RegisterPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegistrationTest extends BaseModel {


    @Test
    public void registrationTest() throws InterruptedException {
        RegisterPage registerP = new RegisterPage(this.driver);
        registerP.register("masd@n11qa.com","123456");

    }

}