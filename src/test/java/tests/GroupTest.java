package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GroupPage;
import pages.LoginPage;
import providers.ConfigFileProvider;

public class GroupTest {

    protected WebDriver driver;
    protected ConfigFileProvider config = new ConfigFileProvider("config.txt");
    GroupPage group;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        new LoginPage(driver).login(config.getLogin(), config.getPassword()).checkLogin();
        group = new GroupPage(driver);
    }

    @Test
    public void testMember(){
        Assert.assertTrue(group.openPage(config.getGroupInWichUserIsMember()).checkUserStatus().inGroup());
    }

    @Test
    public void testNotMember(){
        Assert.assertTrue(group.openPage(config.getGroupInWichUserIsNotMember()).checkUserStatus().notInGroup());
    }

    @Test
    public void testAdministrator(){
        Assert.assertTrue(group.openPage(config.getGroupInWichUserIsAdmin()).checkUserStatus().admin());
    }

    @Test
    public void testWaitingForConfirmation(){
        Assert.assertTrue(group.openPage(config.getGroupInWhichUserWaitingForConfirmation()).checkUserStatus().sendRequest());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
