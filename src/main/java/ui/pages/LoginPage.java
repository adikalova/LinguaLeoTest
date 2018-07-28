package ui.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private By emailInput = By.xpath("//*[@id='email']");
    private By passwordInput = By.xpath("//*[@id='password']");
    private By loginButton = By.xpath("//*[@value='Войти']");
//    private By dictionaryLocator = By.xpath("//*[contains(text(),'Словарь')]");
//
//    public LoginPage clickDictionary(){
//        driver.findElement(dictionaryLocator).click();
//        return this;
//    }

    public LoginPage inputEmail () {
        driver.findElement(emailInput).sendKeys("adikalova@gmail.com");
        return this;
    }

    public LoginPage enterPassword () {
        driver.findElement(passwordInput).sendKeys("A771d6552");
        return this;
    }
    public LoginPage clickLoginButton () {
        driver.findElement(loginButton).click();
        return this;
    }
}
