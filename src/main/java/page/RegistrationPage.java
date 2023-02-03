package page;

import form.RegistrationForm;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends Page {

    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath("//a[text()='Войти']");
    private final By nameInput = By.xpath("//form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//form/fieldset[2]/div/div/input");
    private final By passInput = By.xpath("//form/fieldset[3]/div/div/input");
    private final By incorrectPassMessage = By.xpath("//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForRegistrationPage() {
        waitForElement(registrationButton);
    }
    @Step("Заполнение формы авторизации")
    public void fillRegistrationForm(RegistrationForm registrationForm) {
        driver.findElement(nameInput).sendKeys(registrationForm.getName());
        driver.findElement(emailInput).sendKeys(registrationForm.getEmail());
        driver.findElement(passInput).sendKeys(registrationForm.getPass());
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegistrationButton() {
        clickElement(registrationButton);
    }
    @Step("Клик по кнопке Войти")
    public void clickToLoginLink() {
        clickElement(loginLink);
    }
    @Step("Ожидание сообщения Некорректный пароль")
    public void waitPassFieldError() {
        waitForElement(incorrectPassMessage);
    }
}
