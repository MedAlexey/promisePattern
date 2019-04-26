package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.GroupPage;
import java.util.NoSuchElementException;

public class Promise extends GroupPage{

    private static final By IN_GROUP = By.xpath(".//*[@class='dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide' and contains(text(), 'В группе')]");
    private static final By JOIN_GROUP = By.xpath(".//*[@class='button-pro __wide' and contains(text(), 'Присоединиться')]");
    private static final By SEND_REQUEST = By.xpath(".//*[@class='dropdown_ac button-pro __sec __wide __disabled' and contains(text(), 'Запрос отправлен')]");
    private static final By ADMIN = By.xpath(".//*[@class='dropdown_ac button-pro __sec __disabled __wide' and contains(text(), 'Администратор')]");

    public Promise(WebDriver driver) {
        super(driver);
    }

    //Пользователь состоит в группе
    public boolean inGroup(){
        return isElementPresent(IN_GROUP);
    }

    //Пользователь не состоит в группе
    public boolean notInGroup(){
        return isElementPresent(JOIN_GROUP);
    }

    //Ожидание подтвержения запроса на добавление в закрытую группу
    public boolean sendRequest(){
        return isElementPresent(SEND_REQUEST);
    }

    //Является ли пользователь администратором группы
    public boolean admin(){
        return isElementPresent(ADMIN);
    }

    // Существует ли такой элемент
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
