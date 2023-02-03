package selenium;

import config.SeleniumConfiguration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;

@RunWith(Parameterized.class)
public class HomeTest {
    private LoginPage loginPage;
    private static WebDriver driver;
    private HomePage homePage;

    private final SeleniumConfiguration configuration;

    public HomeTest(SeleniumConfiguration configuration) {
        this.configuration = configuration;
    }


    @Before
    public void setup(){
        driver = configuration.getSetup().get();
        driver.get("https://stellarburgers.nomoreparties.site/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }


    @Parameterized.Parameters
    public static Object[] getParameters(){
        return new Object[]{
                SeleniumConfiguration.chromeConfig(),
                SeleniumConfiguration.yandexConfig()
        };
    }

    @Test
    public void testAccountPage(){
        homePage.clickToAccount();
        loginPage.waitForLoginPage();
    }

    @Test
    public void testLogoHomePage(){
        testAccountPage();
        homePage.clickToLogo();
        homePage.waitForHomePageTitle();
    }

    @Test
    public void testConstructor(){
        testAccountPage();
        homePage.clickToConstructor();
        homePage.waitForHomePageTitle();
    }

    @Test
    public void testBunTab(){
        driver.manage().window().setSize(new Dimension(600,600));
        homePage.clickToConstructor();
        homePage.clickToTipsTab();
        homePage.clickToBunTab();
        Assert.assertEquals( configuration.getBunPosition(), homePage.getBunLocation());
    }
    @Test
    public void testSauceTab(){
        driver.manage().window().setSize(new Dimension(600,600));

        homePage.clickToConstructor();
        homePage.clickToSauceTab();
        Assert.assertEquals( configuration.getSaucePosition(),homePage.getSauceLocation());
    }
    @Test
    public void testTipsTab(){
        driver.manage().window().setSize(new Dimension(600,600));
        homePage.clickToConstructor();
        homePage.clickToTipsTab();
        Assert.assertEquals(configuration.getTipsPosition(),homePage.getTipsLocation());
    }

    @After
    public void close(){
        driver.quit();
    }
}
