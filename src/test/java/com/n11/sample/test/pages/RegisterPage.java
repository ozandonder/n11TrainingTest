package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterPage extends BaseModel {

    public RegisterPage(WebDriver driver) {
        setDriver(driver);
    }

    public void register(String email, String password) throws InterruptedException {
        openBrowser("https://qa.n11.com/");


        visibilityOfElementLocated(By.className("btnSignUp"));

        clickBy(By.className("btnSignUp"));

        setById("firstName", "masd");

        setById("lastName", "123456");

        setById("registrationEmail", email);

        setById("registrationPassword", password);

        setById("passwordAgain", "123456");

        WebElement phoneN = driver.findElement(By.cssSelector("#phoneNumber"));
        WebElement phoneNDiv = driver.findElement(By.cssSelector("#phoneContainer"));
        phoneNDiv.click();
        phoneN.sendKeys("44-444-4444");
        //clickByCss("label[for='genderMale']");

        selectByNameValue("birthDay", "1");

        selectByNameValue("birthMonth", "1");

        selectByNameValue("birthYear", "2000");
        Thread.sleep(2000);


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('genderMale').click();");

        WebElement acceptContract = driver.findElement(By.id("acceptContract"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", acceptContract);

        WebElement sendPromotionalMailAndSms = driver.findElement(By.id("sendPromotionalMailAndSms"));
        executor.executeScript("arguments[0].click();", sendPromotionalMailAndSms);

        setById("captchaText", "N11");
        Thread.sleep(2000);

    }
}
