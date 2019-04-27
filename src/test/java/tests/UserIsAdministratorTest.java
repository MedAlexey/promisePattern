package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.GroupPage;
import pages.LoginPage;

public class UserIsAdministratorTest extends BaseGroupTest {

    private GroupPage groupPage;

    @Before
    public void setUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getLogin(), config.getPassword());
        groupPage = (GroupPage) loginPage.open(config.getGroupInWichUserIsAdmin());
    }

    @Test
    public void userIsAdministratorTest() {
        Assert.assertTrue(groupPage.checkUserStatus().admin(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
