package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends Page {
    private final By logOutButton = By.xpath("//button[text()='Выход']");
    private final By accountButton = By.xpath("//a[text()='Профиль']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @Step("Клик по кнопке выход")
    public void logOut() {
        clickElement(logOutButton);
    }
    @Step("Ожидание загрузки кнопки  входа")
    public void waitForAccountButton() {
        waitForElement(accountButton);
    }
}
