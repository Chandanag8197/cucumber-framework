package chandanlearnings.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

    public WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait explicitWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return explicitWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void windowHandles() {
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles: " + windowHandles);
        String parentWindow = driver.getWindowHandle();

        for (String handle : windowHandles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
