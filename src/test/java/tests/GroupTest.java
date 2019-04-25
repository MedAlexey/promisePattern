package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GroupPage;
import pages.LoginPage;
import patterns.Promise;
import providers.ConfigFileProvider;

public class GroupTest {

    protected WebDriver driver;
    protected ConfigFileProvider config = new ConfigFileProvider("config.txt");

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        new LoginPage(driver).login(config.getLogin(), config.getPassword()).checkLogin();
    }

    @Test
    public void testMember(){
        GroupPage group = new GroupPage(driver);
        Assert.assertEquals(true, group.openPage(config.getGroupInWichUserIsMember()).checkUserStatus().inGroup());
    }

    @Test
    public void testNotMember(){
        GroupPage group = new GroupPage(driver);
        Assert.assertEquals(true, group.openPage(config.getGroupInWichUserIsNotMember()).checkUserStatus().joinGroup());
    }

    @Test
    public void testAdministrator(){
        GroupPage group = new GroupPage(driver);
        Assert.assertEquals(true, group.openPage(config.getGroupInWichUserIsAdmin()).checkUserStatus().admin());
    }

    @Test
    public void testWaitingForConfirmation(){
        GroupPage group = new GroupPage(driver);
        Assert.assertEquals(true, group.openPage(config.getGroupInWhichUserWaitingForConfirmation()).checkUserStatus().sendRequest());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
