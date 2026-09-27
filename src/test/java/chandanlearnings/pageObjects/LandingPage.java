package chandanlearnings.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    public WebDriver driver;
    public String landingPageProductName;

    By searchInput = By.xpath("//input[@type = 'search']");
    By productName = By.cssSelector("h4.product-name");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String shortName) {
        driver.findElement(searchInput).sendKeys(shortName);
    }

    public void waitForSearchResults(String shortName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(productName)
            .stream()
            .anyMatch(e -> e.getText().toLowerCase().contains(shortName.toLowerCase())));
    }

    public String getProductName(String shortName) {
        landingPageProductName = driver.findElements(productName)
            .stream()
            .filter(e -> e.getText().toLowerCase().contains(shortName.toLowerCase()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Product not found: " + shortName))
            .getText()
            .split("-")[0]
            .trim();
        System.out.println("landingPageProductName: " + landingPageProductName);
        return landingPageProductName;
    }
}
