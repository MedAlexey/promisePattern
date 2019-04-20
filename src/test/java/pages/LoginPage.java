package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage  {

    private static final String LOGIN_LOCATOR = ".//input[@name='st.email']";
    private static final String PASSWORD_LOCATOR = ".//input[@name='st.password']";
    private static final String SUBMIT_LOCATOR = ".//input[@data-l='t,sign_in']";
    private static final String LOGIN_CARD_LOCATOR = ".//div[@class='anonym_login_cnt js-login-state']";
    private static final String REGISTRATION_LOCATOR = ".//a[@class='button-pro __sec __wide mb-3x' and contains(text(), 'Регистрация')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public UserMainPage login(String email, String password) {
        driver.get(baseUrl + "/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
        this.check(driver);
        driver.findElement(By.xpath(LOGIN_LOCATOR)).sendKeys(email);
        driver.findElement(By.xpath(PASSWORD_LOCATOR)).sendKeys(password);
        driver.findElement(By.xpath(SUBMIT_LOCATOR)).click();
        return new UserMainPage(driver);
    }

    @Override
    void check(WebDriver driver) {
        driver.findElement(By.xpath(LOGIN_CARD_LOCATOR));
        driver.findElement(By.xpath(LOGIN_LOCATOR));
        driver.findElement(By.xpath(PASSWORD_LOCATOR));
        driver.findElement(By.xpath(SUBMIT_LOCATOR));
        driver.findElement(By.xpath(REGISTRATION_LOCATOR));
    }
}
