package selenium;

import config.SeleniumConfiguration;
import form.RegistrationForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;

@RunWith(Parameterized.class)
public class RegistrationTest {

    private static WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private final SeleniumConfiguration configuration;

    public RegistrationTest(SeleniumConfiguration configuration) {
        this.configuration = configuration;
    }

    @Before
    public void setup() {
        driver = configuration.getSetup().get();
        driver.get("https://stellarburgers.nomoreparties.site/");
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }


    @Parameterized.Parameters
    public static Object[] getParameters() {
        return new Object[]{
                SeleniumConfiguration.chromeConfig(),
                SeleniumConfiguration.yandexConfig()
        };
    }

    @Test
    public void registration() {
        homePage.clickToAccount();
        loginPage.waitForLoginPage();
        loginPage.clickRegistrationLink();
        registrationPage.waitForRegistrationPage();
        registrationPage.fillRegistrationForm(RegistrationForm.randomFrom());
        registrationPage.clickRegistrationButton();
        loginPage.waitForLoginPage();
    }

    @Test
    public void registrationIncorrect() {
        homePage.clickToAccount();
        loginPage.waitForLoginPage();
        loginPage.clickRegistrationLink();
        registrationPage.fillRegistrationForm(RegistrationForm.incorrectPassFrom());
        registrationPage.clickRegistrationButton();
        registrationPage.waitPassFieldError();
    }

    @After
    public void close() {
        driver.quit();
    }
}
