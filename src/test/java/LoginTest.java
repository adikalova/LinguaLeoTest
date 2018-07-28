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

        String emailInput = "//*[@id='email']";
        String passwordInput = "//*[@id='password']";
        String loginButton = "//*[@value='Войти']";

        driver.findElement(By.xpath(emailInput)).sendKeys("adikalova@gmail.com");
        driver.findElement(By.xpath(passwordInput)).sendKeys("A771d6552");
        driver.findElement(By.xpath(loginButton)).click();

        Assert.assertTrue(driver.getTitle().contains("Мои задания"), "Login is successful!");

    }


    @Test(dependsOnMethods = "SuccessfulLoginToLinguaLeo")
    public void myProgress() {

        String dictionary = "//*[contains(text(),'Словарь')]";
        String buttonFind = "//*[@placeholder='Найти']";
        String buttonAdd = "//*[contains(text(),'Добавить')]";
        String butttonAddWorld = "button[type='submit'][class='btn find-word']";
        String addWorldDog = "/html/body/div[13]/div[3]/div/div[1]/a[1]";


        driver.findElement(By.xpath(dictionary)).click();
        driver.findElement(By.xpath(buttonFind)).sendKeys("dog");
        driver.findElement(By.xpath(buttonAdd)).click();
        driver.findElement(By.cssSelector(butttonAddWorld)).click();
        driver.findElement(By.xpath(addWorldDog)).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("[data-show-word-card-popup]")).getText(), "dog  —  собака");

    }


    @AfterTest


    public void closeBrowser() {
        driver.close();
    }


}