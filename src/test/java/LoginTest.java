import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;


    @BeforeTest
    public void startChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Анастасия\\Desktop\\LinguaLeoTests\\enviroment\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://lingualeo.com/ru/login");
    }

    @Test
    public void SuccessfulLoginToLinguaLeo() {
        driver.get("https://lingualeo.com/ru/login");

        By emailInput = By.xpath("//*[@id='email']");
        By passwordInput = By.xpath("//*[@id='password']");
        By loginButton = By.xpath("//*[@value='Войти']");

        driver.findElement(emailInput).sendKeys("adikalova@gmail.com");
        driver.findElement(passwordInput).sendKeys("A771d6552");
        driver.findElement(loginButton).click();

        Assert.assertTrue(driver.getTitle().contains("Мои задания"), "Login is successful!");

    }


    @Test(dependsOnMethods = "SuccessfulLoginToLinguaLeo")
    public void myProgress() {

        By dictionaryLocator =By.xpath( "//*[contains(text(),'Словарь')]");
        By buttonFind = By.xpath("//*[@placeholder='Найти']");
        By buttonAdd = By.xpath("//*[contains(text(),'Добавить')]");
        By butttonAddWorld = By.cssSelector("button[type='submit'][class='btn find-word']");
        By addWorldDog = By.xpath("/html/body/div[13]/div[3]/div/div[1]/a[1]");
        By checkWord =By.cssSelector("[data-show-word-card-popup]");


        driver.findElement(dictionaryLocator).click();
        driver.findElement(buttonFind).sendKeys("dog");
        driver.findElement(buttonAdd).click();
        driver.findElement(butttonAddWorld).click();
        driver.findElement(addWorldDog).click();


        Assert.assertEquals(driver.findElement(checkWord).getText(), "dog  —  собака");

    }


    @AfterTest


    public void closeBrowser() {
        driver.close();
    }


}