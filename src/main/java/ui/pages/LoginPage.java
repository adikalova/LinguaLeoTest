package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage startChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Анастасия\\Desktop\\LinguaLeoTests\\enviroment\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://lingualeo.com/ru/login");
        return this ;
    }


    private By emailInput = By.xpath("//*[@id='email']");
    private By passwordInput = By.xpath("//*[@id='password']");
    private By loginButton = By.xpath("//*[@value='Войти']");

    public LoginPage InputEmail () {
        driver.findElement(emailInput).sendKeys("adikalova@gmail.com");
        return this;
    }

    public LoginPage EnterPassword () {
        driver.findElement(passwordInput).sendKeys("A771d6552");
        return this;
    }
    public LoginPage ClickLoginButton () {
        driver.findElement(loginButton).click();
        return this;
    }








}
