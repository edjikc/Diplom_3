package page;

import form.LoginForm;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    private final By loginLabel = By.xpath("//h2[text()='Вход']");
    private final By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By passInput = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoginPage() {
        waitForElement(loginLabel);
    }

    public void clickRegistrationLink() {
        clickElement(registrationLink);
    }
    @Step("Заполнить форму авторизации")
    public void fillLoginForm(LoginForm loginForm) {
        driver.findElement(nameInput).sendKeys(loginForm.getName());
        driver.findElement(passInput).sendKeys(loginForm.getPass());
    }
    @Step("Клик по кнопке Войти в аккаунт")
    public void clickToLogin() {
        clickElement(loginButton);
    }

}
