package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.WebDriver;

public class Browser extends BaseModel {

    public Browser(WebDriver driver) {
        setDriver(driver);
    }

    public void openBrowser(String url) throws InterruptedException {
        driver.get(url);
        waiter(2000);
        driver.manage().window().maximize();

    }

}
