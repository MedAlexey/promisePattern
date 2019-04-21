package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GroupPage;
import pages.LoginPage;
import pages.UserMainPage;

public class GroupTest extends BaseTest {



    @Before
    public void setUp(){
        driver = new ChromeDriver();
        LoginPage userLogin = new LoginPage(driver);
        UserMainPage userPage = userLogin.login(config.getLogin(),config.getPassword());
        userPage.checkLogin();
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
