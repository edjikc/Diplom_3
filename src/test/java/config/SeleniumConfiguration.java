package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.function.Supplier;

import static config.SeleniumConstants.*;

public class SeleniumConfiguration {
    private final Supplier<ChromeDriver> setup;
    private final int bunPosition;
    private final int saucePosition;
    private final int tipsPosition;

    public SeleniumConfiguration(Supplier<ChromeDriver> setup, int bunPosition, int saucePosition, int tipsPosition) {
        this.setup = setup;
        this.bunPosition = bunPosition;
        this.saucePosition = saucePosition;
        this.tipsPosition = tipsPosition;
    }

    public static SeleniumConfiguration yandexConfig() {
        return new SeleniumConfiguration(() -> {
            WebDriverManager.chromiumdriver().driverVersion(YANDEX_CHROMIUM_VERSION).setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(new File(YANDEX_BROWSER_PATH));
            return new ChromeDriver(chromeOptions);
        }, YANDEX_BUN_POSITION, YANDEX_SAUCE_POSITION, YANDEX_TIPS_POSITION);
    }

    public static SeleniumConfiguration chromeConfig() {
        return new SeleniumConfiguration(() -> {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }, CHROME_BUN_POSITION, CHROME_SAUCE_POSITION, CHROME_TIPS_POSITION);
    }

    public Supplier<ChromeDriver> getSetup() {
        return setup;
    }

    public int getBunPosition() {
        return bunPosition;
    }

    public int getSaucePosition() {
        return saucePosition;
    }

    public int getTipsPosition() {
        return tipsPosition;
    }
}
