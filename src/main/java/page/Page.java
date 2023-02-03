package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElement(By element){
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void clickElement(By element){
        driver.findElement(element).click();
    }
}
