package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import providers.ConfigFileProvider;

import java.util.concurrent.TimeUnit;

public abstract class BaseGroupTest {
    WebDriver driver;
    ConfigFileProvider config = new ConfigFileProvider("config.txt");

    BaseGroupTest() {
        setUpDriver();
    }

    // задаются начальные параметры драйвера
    // происходит переход на страницу авторизации
    private void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ok.ru/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
    }

}
