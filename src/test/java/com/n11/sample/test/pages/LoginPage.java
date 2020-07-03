package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseModel {

    public LoginPage(WebDriver driver) {
        setDriver(driver);
    }

    public void login(String email, String password) {

        clickBy(By.className("btnSignIn"));
        visibilityOfElementLocated(By.id("email"));
        setById("email", email);
        setById("password", password);
        clickBy(By.id("loginButton"));
        visibilityOfElementLocated(By.cssSelector(".menuLink.user"));

    }

}
