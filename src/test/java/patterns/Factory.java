package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.GroupPage;
import pages.LoginPage;
import pages.UserMainPage;

import java.util.concurrent.TimeUnit;

public class Factory {

    public static BasePage openPage(WebDriver driver, String link) {
        new WebDriverWait(driver, 30);
        setUpDriver(driver, 0);
        driver.get(link);

        boolean correctPage = true;
        try {
            new LoginPage(driver);
        } catch (Exception ignore) {
            correctPage = false;
        }

        if (correctPage) {
            setUpDriver(driver,30);
            return new LoginPage(driver);
        }

        correctPage = true;
        try {
            new GroupPage(driver);
        } catch (Exception ignore) {
            correctPage = false;
        }

        if (correctPage) {
            setUpDriver(driver,30);
            return new GroupPage(driver);
        }

        correctPage = true;
        try {
            new UserMainPage(driver);
        } catch (Exception ignore) {
            correctPage = false;
        }

        if (correctPage) {
            setUpDriver(driver,30);
            return new UserMainPage(driver);
        }

        return null;
    }

    private static void setUpDriver(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

}
