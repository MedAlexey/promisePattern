package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.GroupPage;
import pages.LoginPage;

public class UserIsWaitingForConfirmationTest extends BaseGroupTest {

    private GroupPage groupPage;

    @Before
    public void setUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(config.getLogin(), config.getPassword());
        groupPage = loginPage.openGroupPage(config.getGroupInWhichUserWaitingForConfirmation());
    }

    @Test
    public void userIsAdministratorTest() {
        Assert.assertTrue(groupPage.checkUserStatus().sendRequest(driver));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
