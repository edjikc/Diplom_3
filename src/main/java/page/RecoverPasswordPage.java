package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage extends Page {

    private final By recoverTitle = By.xpath("//h2[text()='Восстановление пароля']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public RecoverPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание кнопки Восстановление пароля")
    public void waitForRecoverPage() {
        waitForElement(recoverTitle);
    }

    @Step("Клик по кнопке Войти")
    public void clickToLoginLink() {
        clickElement(loginLink);
    }
}
