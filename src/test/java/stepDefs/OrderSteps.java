package stepDefs;

import context.ContextKeys;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.ProductPage;

import java.util.Map;

public class OrderSteps {
    ProductPage productPage;
    CheckoutPage checkoutPage;
    AddToCartPage addToCartPage;
    private final TestContext context;

    public OrderSteps(TestContext context){
        productPage = new ProductPage();
        checkoutPage = new CheckoutPage();
        addToCartPage = new AddToCartPage();
        this.context = context;
    }

    @When("User clicks on checkout button")
    public void user_clicks_on_checkout_button() {
        addToCartPage.clicksOnCheckoutButton();
    }
    @Then("User is landed on Checkout Info page")
    public void user_is_landed_on_checkout_info_page() {
        Assert.assertTrue(checkoutPage.getCheckoutTitlePage("Checkout: Your Information"),"Checkout: Your Information Page is not displayed");
    }
    @Then("User enters the below details")
    public void user_enters_the_below_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        checkoutPage.enterCheckoutDetails(data.get("first_name"),data.get("last_name"),data.get("zip_code"));
    }
    @Then("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        checkoutPage.clicksOnContinueButton();
    }
    @Then("User is landed on Checkout Overview page")
    public void user_is_landed_on_checkout_overview_page() {
        Assert.assertTrue(checkoutPage.getCheckoutTitlePage("Checkout: Overview"),"Checkout: Overview Page is not displayed");
    }
    @Then("User verifies the correct product is showing on checkout overview page")
    public void user_verifies_the_correct_product_is_showing_on_checkout_overview_page() {
       Assert.assertEquals(productPage.getFirstProductName(),context.get(ContextKeys.PRODUCT_NAME,String.class),"Same Product name is not on the Checkout Overview page");
    }
    @Then("User clicks on Finish button")
    public void user_clicks_on_finish_button() {
        checkoutPage.clicksOnFinishButton();
    }
    @Then("User is successfully placed the order and success message is displaying on the screen")
    public void user_is_successfully_placed_the_order_and_success_message_is_displaying_on_the_screen() {
        Assert.assertEquals(checkoutPage.getOrderSuccessMessage(),"Thank you for your order!","User is not able to place the order and success message is not displayed");
    }

}
