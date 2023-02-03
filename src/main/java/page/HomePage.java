package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

    private final By accountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By recoverPassLink = By.xpath("//a[text()='Восстановить пароль']");
    private final By homePageTitle = By.xpath("//h1");
    private final By logo = By.xpath("//div/header/nav/div/a");
    private final By constructor = By.xpath("//header/nav/ul/li[1]/a");

    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By sauceTab = By.xpath("//section[1]/div[1]/div[2]");
    private final By tipsTab = By.xpath("//section[1]/div[1]/div[3]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Клик в конструкторе по надписи Булки")
    public void clickToBunTab() {
        clickElement(bunTab);
    }

    public int getBunLocation(){
        return driver.findElement(bunTab).getLocation().getY();
    }
    public int getSauceLocation(){
        return driver.findElement(sauceTab).getLocation().getY();
    }
    public int getTipsLocation(){
        return driver.findElement(tipsTab).getLocation().getY();
    }
    @Step("Клик в конструкторе по надписи Соус")
    public void clickToSauceTab() {
        clickElement(sauceTab);
    }
    @Step("Клик в конструкторе по надписи Начинка")
    public void clickToTipsTab() {
        clickElement(tipsTab);
    }
    @Step("Клик по кнопке Личный кабинет")
    public void clickToAccount() {
        clickElement(accountButton);
    }
    @Step("Клик по кнопке Войти в аккаунт")
    public void clickToLogin() {
        clickElement(loginButton);

    }
    @Step("Клик по Логотипу")
    public void clickToLogo() {
        clickElement(logo);

    }
    @Step("Клик по кнопке Крнструктор")
    public void clickToConstructor() {
        clickElement(constructor);

    }
    @Step("Клик по кнопке Восстановить пароль")
    public void clickToRecoverPassLink() {
        clickElement(recoverPassLink);
    }
    @Step("Клик по надписи Соберите бургер")
    public void waitForHomePageTitle() {
        waitForElement(homePageTitle);
    }
}
