package com.n11.sample.test.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseModel {

    public WebDriver driver;
    public int waitTime = 100;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    public void setById(String id, String value) {
        WebElement loginElement = driver.findElement(By.id(id));
        loginElement.click();
        loginElement.clear();
        loginElement.sendKeys(value);
    }

    public void setByCss(String css, String value) {
        WebElement loginElement = driver.findElement(By.cssSelector(css));
        loginElement.click();
        loginElement.clear();
        loginElement.sendKeys(value);
    }

    public void clickBy(By by) {
        WebElement loginButton = driver.findElement(by);
        loginButton.click();

    }

    public void clickByCss(String css) {
        WebElement cssElement = driver.findElement(By.cssSelector(css));
        cssElement.click();

    }

    public void selectByNameValue(String name, String value) {
        WebDriverWait waiter = new WebDriverWait(driver, 5);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void clickByLinkText(String text) {
        WebElement wElement = driver.findElement(By.linkText(text));
        wElement.click();

    }

    public void clickByXpath(String text) {
        WebElement wElement = driver.findElement(By.xpath(text));
        wElement.click();
    }

    public void openBrowser(String url) throws InterruptedException {
        driver.get(url);
        waiter(2000);
        driver.manage().window().maximize();

    }

    public void waiter(int milis) throws InterruptedException {

        Thread.sleep(milis);
    }

    public void presenceOfElementLocated(By by) {

        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void visibilityOfElementLocated(By by) {

        WebDriverWait waiter = new WebDriverWait(driver, waitTime);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void invisibilityOfElementLocated(By by) {

        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }


}
