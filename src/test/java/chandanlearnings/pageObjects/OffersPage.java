package chandanlearnings.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    By searchInput = By.xpath("//input[@type = 'search']");
    By productName = By.cssSelector("tr td:nth-child(1)");
    By topDealsLink = By.linkText("Top Deals");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopDealsLink() {
        driver.findElement(topDealsLink).click();
    }

    public void searchItem(String shortName) {
        driver.findElement(searchInput).sendKeys(shortName);
    }

    public String getProductName(String shortName) {
        offerPageProductName = driver.findElements(productName)
            .stream()
            .filter(e -> e.getText().toLowerCase().contains(shortName.toLowerCase()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Product not found: " + shortName))
            .getText();
        System.out.println("OffersPageProductName: " + offerPageProductName);
        return offerPageProductName;
    }
}
