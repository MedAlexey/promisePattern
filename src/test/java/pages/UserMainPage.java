package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends BasePage {

    private static final By LOGO_LOCATOR = By.xpath(".//div [contains(@id,'topPanelLeftCorner')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    void check(WebDriver driver) {
        driver.findElement(LOGO_LOCATOR);
    }
}
