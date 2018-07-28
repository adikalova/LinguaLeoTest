package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DasboardPage extends BasePage{

    private By dictionaryLocator = By.xpath("//*[contains(text(),'Словарь')]");
    private By buttonFind = By.xpath("//*[@placeholder='Найти']");
    private By buttonAdd = By.xpath("//*[contains(text(),'Добавить')]");
    private By buttonAddWorld = By.cssSelector("button[type='submit'][class='btn find-word']");
    private By addWorld = By.xpath("/html/body/div[13]/div[3]/div/div[1]/a[1]");
    private By checkWord = By.cssSelector("[data-show-word-card-popup]");


    public DasboardPage clickDictionary() {
        driver.findElement(dictionaryLocator).click();
        return this;
    }

    public DasboardPage enterWord(String word) {
        driver.findElement(buttonFind).sendKeys(word);
        return this;
    }

    public DasboardPage clickAddButton(){
        driver.findElement(buttonAdd).click();
        return this;
    }

    public DasboardPage clickAddWordButton(){
        driver.findElement(buttonAddWorld).click();
        return this;
    }
    public DasboardPage clickAddWord(){
        driver.findElement(addWorld).click();
        return this;
    }
    public boolean isWordWithTextPresent() {
        By buttonSelector = checkWord;
        try {
            driver.findElement(buttonSelector);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

