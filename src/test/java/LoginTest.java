import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        public void loginToLingualeo() {
            driver.findElement(By.id("email")).sendKeys("adikalova@gmail.com");
            driver.findElement(By.id("password")).sendKeys("A771d6552");
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[3]/form/input[4]")).click();

            Assert.assertTrue(driver.getTitle().contains("Мои задания"), "Login is successful!");

        }

    }

