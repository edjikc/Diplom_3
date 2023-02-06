package selenium;

import config.SeleniumConfiguration;
import form.LoginForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.*;

@RunWith(Parameterized.class)
public class LoginTest {
    private static WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RecoverPasswordPage recoverPasswordPage;

    private final LoginForm loginForm = new LoginForm("H2O_Selenium_Qa@qa.ru", "123123");
    private final SeleniumConfiguration configuration;

    public LoginTest(SeleniumConfiguration configuration) {
        this.configuration = configuration;
    }


    @Parameterized.Parameters
    public static Object[] getParameters() {
        return new Object[]{
                SeleniumConfiguration.chromeConfig(),
                SeleniumConfiguration.yandexConfig()
        };
    }

    @Before
    public void setup() {
        driver = configuration.getSetup().get();
        driver.get("https://stellarburgers.nomoreparties.site/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrationPage = new RegistrationPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void loginMainPage() {
        homePage.clickToLogin();
    }

    @Test
    public void accountLogin() {
        homePage.clickToAccount();
        login();
    }

    @Test
    public void registrationPageLogin() {
        homePage.clickToAccount();
        loginPage.clickRegistrationLink();
        registrationPage.waitForRegistrationPage();
        registrationPage.clickToLoginLink();
        login();
    }

    @Test
    public void recoverPageLogin() {
        homePage.clickToAccount();
        homePage.clickToRecoverPassLink();
        recoverPasswordPage.waitForRecoverPage();
        recoverPasswordPage.clickToLoginLink();
        login();
    }

    @Test
    public void logOut() {
        homePage.clickToAccount();
        login();
        homePage.clickToAccount();
        accountPage.waitForAccountButton();
        accountPage.logOut();
        loginPage.waitForLoginPage();
    }

    private void login() {
        loginPage.waitForLoginPage();
        loginPage.fillLoginForm(loginForm);
        loginPage.clickToLogin();
        homePage.waitForHomePageTitle();
    }

    @After
    public void close() {
        driver.quit();
    }
}
