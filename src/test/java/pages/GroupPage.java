package pages;

import org.openqa.selenium.WebDriver;

public class GroupPage extends BasePage{

    public GroupPage(WebDriver driver){
        super(driver);
    }

    public GroupPage openPage(String link){
        driver.get(link);
        return new GroupPage(driver);
    }

    @Override
    void check(WebDriver driver) {

    }
}
