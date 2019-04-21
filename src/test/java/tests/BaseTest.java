package tests;

import org.openqa.selenium.WebDriver;
import providers.ConfigFileProvider;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigFileProvider config = new ConfigFileProvider("config.txt");
}
