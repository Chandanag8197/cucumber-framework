package chandanlearnings.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import chandanlearnings.pageObjects.OffersPage;
import chandanlearnings.utils.testContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OffersPagestepDefinition {

    public testContext context;
    public WebDriver driver;

    public OffersPagestepDefinition(testContext context) {
        this.context = context;
    }

    @Then("User searched the same {string} shortname in offers page")
    public void user_searched_the_same_shortname_in_offers_page(String shortName) throws InterruptedException {
        OffersPage offersPage = context.pageObjectManager.getOffersPage();
        offersPage.clickTopDealsLink();
        context.commonUtils.windowHandles();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        context.offerPageProductName = offersPage.getProductName(shortName);
        System.out.println("offerPageProductName: " + context.offerPageProductName);
    }

    @And("validate product name in offers page matches with actual name of product")
    public void validate_product_name_in_offers_page_matches_with_actual_name_of_product() {
        Assert.assertEquals(context.landingPageProductName, context.offerPageProductName);
    }
}
