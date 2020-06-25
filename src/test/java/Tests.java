import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Tests extends BaseTest {

    @Test
    public void registerTest() throws InterruptedException {

        openBrowser("https://qa.n11.com/");
        visibilityOfElementLocated(By.className("btnSignUp"));
        clickBy(By.className("btnSignUp"));
        setById("firstName", "masd");
        setById("lastName", "123456");
        setById("registrationEmail", "masd@n11qa.com");
        setById("registrationPassword", "123456");
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


    @Test
    public void paymentTest() throws InterruptedException {

        openBrowser("https://www.n11.com/");
        driver.findElement(By.cssSelector(".closeBtn")).click();
        login("acan98529@gmail.com", "test123");

        clickByCss(".catMenuItem:nth-child(2) > a");
        visibilityOfElementLocated(By.cssSelector(".mainCat:nth-child(1) > a"));
        clickByCss(".mainCat:nth-child(1) > a");
        visibilityOfElementLocated(By.cssSelector("#view .column:nth-child(1) .pro a"));
        clickByCss("#view .column:nth-child(1) .pro a");

        visibilityOfElementLocated(By.linkText("Sepete Ekle"));

        clickByLinkText("Sepete Ekle");

        if (!driver.findElements(By.cssSelector(".btn.btnBlack.confirm")).isEmpty()) {
            driver.findElement(By.cssSelector(".btn.btnBlack.confirm")).click();
        }
        invisibilityOfElementLocated(By.cssSelector(".btn.btnBlack.confirm"));
        visibilityOfElementLocated(By.cssSelector(".myBasket"));
        clickByCss(".myBasket");



        if (!driver.findElements(By.xpath("//*[@id='boxAddress']/div[8]/div[2]/div/span[3]")).isEmpty()) {
            clickByCss("#boxAddress > div:nth-child(10) > div.addressBox.isActive > div > span.statusBtn__delete.js-deleteAddressBoxBtn");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[5]/div/div/span[2]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);
            //clickByXpath("");
            clickByLinkText("Evet");
        }
        visibilityOfElementLocated(By.xpath("//*[@id='boxAddress']/div[8]/div[2]/p/span"));
        clickByXpath("//*[@id='boxAddress']/div[8]/div[2]/p/span");
        newAddressCreate("Ali Can","depo");
        Thread.sleep(2000);

        visibilityOfElementLocated(By.cssSelector("#js-goToPaymentBtn"));
        clickByCss("#js-goToPaymentBtn");

        cardForm("1234567890123456");
        Thread.sleep(5000);

    }


}