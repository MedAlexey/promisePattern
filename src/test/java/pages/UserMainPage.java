package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends BasePage {

    private static final By LOGO_LOCATOR = By.xpath("//*[contains(@id,'topPanelLeftCorner')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

   public GroupPage checkLogin(){
       this.check(driver);
       return new GroupPage(driver);
    }

    @Override
    void check(WebDriver driver) {
        driver.findElement(LOGO_LOCATOR);
    }
}
