package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import patterns.Factory;

import java.util.NoSuchElementException;

public abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        check(driver);
    }

    void sendKeys(By element, String keys) {
        driver.findElement(element).sendKeys(keys);
    }

    void click(By element) {
        driver.findElement(element).click();
    }

    boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public BasePage open(String link) {
        return Factory.openPage(driver, link);
    }

    public GroupPage openGroupPage(String link) {
        driver.get(link);
        return new GroupPage(driver);
    }

    abstract void check(WebDriver driver);
}