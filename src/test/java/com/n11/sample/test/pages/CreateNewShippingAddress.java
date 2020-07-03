package com.n11.sample.test.pages;

import com.n11.sample.test.base.BaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewShippingAddress extends BaseModel {

    public CreateNewShippingAddress(WebDriver driver) {
        setDriver(driver);
    }

    public void createNewShippingAddress(String name, String addressName) throws InterruptedException {
        if (!driver.findElements(By.xpath("//*[@id='boxAddress']/div[8]/div[2]/div/span[3]")).isEmpty()) {
            clickByCss("#boxAddress > div:nth-child(10) > div.addressBox.isActive > div > span.statusBtn__delete.js-deleteAddressBoxBtn");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[5]/div/div/span[2]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            //clickByXpath("");
            clickByLinkText("Evet");
        }

        visibilityOfElementLocated(By.xpath("//*[@id='boxAddress']/div[8]/div[2]/p/span"));

        clickByXpath("//*[@id='boxAddress']/div[8]/div[2]/p/span");


        visibilityOfElementLocated(By.cssSelector("#fullName"));

        setById("fullName", name);

        WebElement phoneN = driver.findElement(By.cssSelector("#gsm"));
        phoneN.click();
        phoneN.sendKeys("44-444-4444");

        selectByNameValue("countryCode", "TR");
        visibilityOfElementLocated(By.xpath("//*[@id='cityId']/option[2]"));
        selectByNameValue("cityId", "2501");
        visibilityOfElementLocated(By.xpath("//*[@id='districtId']/option[2]"));
        selectByNameValue("districtId", "22694");
        visibilityOfElementLocated(By.xpath("//*[@id='neighbourhoodId']/option[2]"));
        selectByNameValue("neighborhoodId", "1");

        setById("addressDetail", "address detail");
        setById("addressName", addressName);
        setById("tcNO", "32047435132");
        Thread.sleep(2000);
        clickByCss(".btnHolder .btn.btnBlack.js-saveAddressBtn");


    }

}
