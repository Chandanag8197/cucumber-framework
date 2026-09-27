package chandanlearnings.stepDefinitions;

import org.openqa.selenium.WebDriver;

import chandanlearnings.pageObjects.CheckOutPage;
import chandanlearnings.utils.testContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutPageStepDefinition {

    public WebDriver driver;
    public testContext context;

    public CheckOutPageStepDefinition(testContext context){
        this.context = context;
    }

    private CheckOutPage getCheckOutPage() {
        return context.pageObjectManager.getCheckOutPage();
    }

    @Given("the shopper is on the store home page")
    public void the_shopper_is_on_the_store_home_page() {

    }

    @When("the shopper adds {string} to the cart")
    public void the_shopper_adds_to_the_cart(String fullName) throws InterruptedException {
        getCheckOutPage().addToCart(fullName);
    }

    @When("the shopper opens checkout")
    public void the_shopper_opens_checkout() throws InterruptedException {
        getCheckOutPage().checkOutpageClick();
    }

    @Then("checkout should display {string} with quantity {int}")
    public void checkout_should_display_with_quantity(String fullName, Integer int1) throws InterruptedException {
        getCheckOutPage().verifyCheckOut(fullName, int1);
    }
}
