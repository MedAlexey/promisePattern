package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GroupPage;
import pages.LoginPage;

public class GroupTest extends BaseTest {



    @Before
    public void setUp(){
        driver = new ChromeDriver();
        new LoginPage(driver).login(config.getLogin(), config.getPassword()).checkLogin();
    }

    @Test
    public void testMember(){
        GroupPage group = new GroupPage(driver);
        group.openPage(config.getGroupInWichUserIsMember());
    }

    @Test
    public void testNotMember(){
        GroupPage group = new GroupPage(driver);
        group.openPage(config.getGroupInWichUserIsNotMember());
    }

    @Test
    public void testAdministrator(){
        GroupPage group = new GroupPage(driver);
        group.openPage(config.getGroupInWichUserIsAdmin());
    }

    @Test
    public void testWaitingForConfirmation(){
        GroupPage group = new GroupPage(driver);
        group.openPage(config.getGroupInWhichUserWaitingForConfirmation());
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
