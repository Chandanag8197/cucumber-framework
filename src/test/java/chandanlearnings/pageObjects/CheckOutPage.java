package chandanlearnings.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import chandanlearnings.utils.CommonUtils;

public class CheckOutPage {

    public WebDriver driver;
    public CommonUtils commonUtils;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.commonUtils = new CommonUtils(driver);
    }

    By productName = By.cssSelector("h4.product-name");
    By checkOutPageButton = By.cssSelector("a.cart-icon");
    By checkOutPageProductName = By.xpath("(//li[@class='cart-item'])[1]//p[@class='product-name']");
    By checkOutQuantity = By.xpath("(//p[@class='quantity'])[1]");

    public void addToCart(String name) {
        By addToCartButton = By.xpath("//div[@class='product'][.//h4[contains(normalize-space(.), '" + name + "')]]//button");
        commonUtils.waitForElementToBeClickable(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public void checkOutpageClick() {
        commonUtils.waitForElementToBeClickable(checkOutPageButton);
        driver.findElement(checkOutPageButton).click();
    }

    public void verifyCheckOut(String name, Integer quantity) {
        WebElement cartProduct = commonUtils.waitForElementToBeVisible(checkOutPageButton);
        WebElement quantityElement = commonUtils.waitForElementToBeVisible(checkOutQuantity);

        if (cartProduct.getText().split("-")[0].trim().equalsIgnoreCase(name.trim())) {
            System.out.println("Checkout product is successful");
        }

        String quantityText = quantityElement.getText().replaceAll("[^0-9]", "");
        if (Integer.parseInt(quantityText) == quantity) {
            System.out.println("Checkout Quantity is Successful");
        }
    }
}
