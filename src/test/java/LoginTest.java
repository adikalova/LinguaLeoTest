import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @Test
    public void SuccessfulLoginToLinguaLeo() {
        String Title = "Lingualeo";

        loginPage.startChrome ();
        loginPage.InputEmail();
        loginPage.EnterPassword();
        loginPage.ClickLoginButton();

        Assert.assertEquals((Title),"Lingualeo");
    }


//    @Test(dependsOnMethods = "SuccessfulLoginToLinguaLeo")
//    public void myProgress() {
//
//        By dictionaryLocator =By.xpath( "//*[contains(text(),'Словарь')]");
//        By buttonFind = By.xpath("//*[@placeholder='Найти']");
//        By buttonAdd = By.xpath("//*[contains(text(),'Добавить')]");
//        By butttonAddWorld = By.cssSelector("button[type='submit'][class='btn find-word']");
//        By addWorldDog = By.xpath("/html/body/div[13]/div[3]/div/div[1]/a[1]");
//        By checkWord =By.cssSelector("[data-show-word-card-popup]");
//
//
//        driver.findElement(dictionaryLocator).click();
//        driver.findElement(buttonFind).sendKeys("dog");
//        driver.findElement(buttonAdd).click();
//        driver.findElement(butttonAddWorld).click();
//        driver.findElement(addWorldDog).click();
//
//
//        Assert.assertEquals(driver.findElement(checkWord).getText(), "dog  —  собака");
//
//    }


}