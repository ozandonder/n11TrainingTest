package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToBasket extends BaseModel {

    public AddToBasket(WebDriver driver) {
        setDriver(driver);
    }

    public void addToBasket() {

        clickByCss(".catMenuItem:nth-child(2) > a");

        visibilityOfElementLocated(By.cssSelector(".mainCat:nth-child(1) > a"));

        clickByCss(".mainCat:nth-child(1) > a");

        visibilityOfElementLocated(By.cssSelector("#view .column:nth-child(1) .pro a"));

        clickByCss("#view .column:nth-child(1) .pro a");

        visibilityOfElementLocated(By.linkText("Sepete Ekle"));

        clickByLinkText("Sepete Ekle");

        if(!driver.findElements(By.cssSelector(".btn.btnBlack.confirm")).

                isEmpty())

        {
            driver.findElement(By.cssSelector(".btn.btnBlack.confirm")).click();
        }

        invisibilityOfElementLocated(By.cssSelector(".btn.btnBlack.confirm"));

        visibilityOfElementLocated(By.cssSelector(".myBasket"));

        clickByCss(".myBasket");
    }

}
