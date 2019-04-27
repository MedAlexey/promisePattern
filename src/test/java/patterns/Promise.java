package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class Promise {

    private static final By IN_GROUP = By.xpath(".//*[@class='dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide' and contains(text(), 'В группе')]");
    private static final By JOIN_GROUP = By.xpath(".//*[@class='button-pro __wide' and contains(text(), 'Присоединиться')]");
    private static final By SEND_REQUEST = By.xpath(".//*[@class='dropdown_ac button-pro __sec __wide __disabled' and contains(text(), 'Запрос отправлен')]");
    private static final By ADMIN = By.xpath(".//*[@class='dropdown_ac button-pro __sec __disabled __wide' and contains(text(), 'Администратор')]");

    //Пользователь состоит в группе
    public boolean inGroup(WebDriver driver){
        return isElementPresent(driver, IN_GROUP);
    }

    //Пользователь не состоит в группе
    public boolean notInGroup(WebDriver driver){
        return isElementPresent(driver, JOIN_GROUP);
    }

    //Ожидание подтвержения запроса на добавление в закрытую группу
    public boolean sendRequest(WebDriver driver){
        return isElementPresent(driver, SEND_REQUEST);
    }

    //Является ли пользователь администратором группы
    public boolean admin(WebDriver driver){
        return isElementPresent(driver, ADMIN);
    }

    // Существует ли такой элемент
    private boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
