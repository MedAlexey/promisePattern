package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GroupPage;
import pages.LoginPage;
import pages.UserMainPage;

public class GroupTest extends BaseTest {

    UserMainPage userPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        LoginPage userLogin = new LoginPage(driver);
        userPage = userLogin.login(config.getLogin(),config.getPassword());
    }

    @Test
    public void testMember(){
        GroupPage group = userPage.toGroup(config.getGroupInWichUserIsMember());
    }

    @Test
    public void testNotMember(){
        GroupPage group = userPage.toGroup(config.getGroupInWichUserIsNotMember());
    }

    @Test
    public void testAdministrator(){
        GroupPage group = userPage.toGroup(config.getGroupInWichUserIsAdmin());
    }

    @Test
    public void testWaitingForConfirmation(){
        GroupPage group = userPage.toGroup(config.getGroupInWhichUserWaitingForConfirmation());
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
