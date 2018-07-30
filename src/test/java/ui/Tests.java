package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.pages.BasePage;
import ui.pages.DasboardPage;
import ui.pages.LoginPage;

public class Tests {
    public static WebDriver driver;
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    DasboardPage dasboardPage = new DasboardPage();


    @BeforeTest
    public void SuccessfulLoginToLinguaLeo() {
        String Title = "Lingualeo";
        basePage.startChrome();

        loginPage.inputEmail()
                .enterPassword()
                .clickLoginButton();

        Assert.assertEquals((Title), "Lingualeo");
    }


    @Test
    public void myProgress() {
        String word = "dog";

        dasboardPage.clickDictionary()
                .enterWord(word)
                .clickAddButton()
                .clickAddWordButton()
                .clickAddWord();

        Assert.assertTrue(dasboardPage.isWordWithTextPresent());

    }


}
