package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends BasePage {

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public GroupPage toGroup(String link){
        driver.get(link);
        return new GroupPage(driver);
    }

    @Override
    void check(WebDriver driver) {
    }
}
