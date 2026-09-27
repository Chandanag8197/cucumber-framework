package chandanlearnings.stepDefinitions;

import org.openqa.selenium.WebDriver;
import chandanlearnings.pageObjects.LandingPage;
import chandanlearnings.utils.testContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LandingPageStepDefinition {

    public WebDriver driver;
    public testContext context;

    // private static final testContext context = testContext.getInstance();
    public LandingPageStepDefinition(testContext context) {
        this.context = context;

        
    }
    

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
        
    }

    @When("User searched with {string} shortname and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
        LandingPage landingPage = context.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);
        landingPage.waitForSearchResults(shortName);
        context.landingPageProductName = landingPage.getProductName(shortName);
    }
}
