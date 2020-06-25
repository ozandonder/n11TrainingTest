import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public WebDriver driver;
    public int waitTime = 100;

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
        Thread.sleep(2000);
        driver.manage().window().maximize();

    }

    public void login(String email, String password) {

        clickBy(By.className("btnSignIn"));
        visibilityOfElementLocated(By.id("email"));
        setById("email", email);
        setById("password", password);
        clickBy(By.id("loginButton"));
        visibilityOfElementLocated(By.cssSelector(".menuLink.user"));

    }

    public void newAddressCreate(String name, String addressName) throws InterruptedException {


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

    public void cardForm(String cardNumber) {
        visibilityOfElementLocated(By.cssSelector(".formfield.cardNumberField input:nth-child(3)"));
        setByCss(".formfield.cardNumberField input:nth-child(3)", "1234567890123456");
        setById("cardOwnerName", "ali can");
        selectByNameValue("paymentModel.creditCardModel.expireMonth", "2");
        selectByNameValue("paymentModel.creditCardModel.expireYear", "2022");
        setById("securityCode", "123");

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
