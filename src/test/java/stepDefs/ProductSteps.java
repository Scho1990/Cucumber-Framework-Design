package stepDefs;

import context.ContextKeys;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;

public class ProductSteps {
    ProductPage productPage;
    private final TestContext context;

    public ProductSteps(TestContext context) {
        productPage = new ProductPage();
        this.context = context;
    }

    @Given("User is on product page")
    public void user_is_on_product_page() {
        Assert.assertTrue(productPage.isProductPageTitleDisplayed(),"User is not on the Product page");
    }
    @When("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() {
        context.set(ContextKeys.PRODUCT_NAME,productPage.getFirstProductName());
        productPage.clicksOnAddToCartButton();
    }
    @Then("Add to Cart button changed to Remove button")
    public void add_to_cart_button_changed_to_remove_button() {
        Assert.assertEquals(productPage.buttonChangedToRemoved(context.get(ContextKeys.PRODUCT_NAME,String.class)),"Remove","Add to Cart button is not changed to Remove button");
    }
    @Then("Product count is showing {int} on add to cart icon")
    public void product_count_is_showing_on_add_to_cart_icon(Integer expectedCount) {
        Assert.assertEquals(productPage.productCountOnCartIcon(),expectedCount,"Product count is not on the Cart icon");
    }
    @When("User clicks on Add to cart icon button")
    public void user_clicks_on_add_to_cart_icon_button() {
          productPage.clickOnCartIcon();
    }
    @Then("User is able to see the correct product in Add to cart page")
    public void user_is_able_to_see_the_correct_product_in_add_to_cart_page() {
          Assert.assertEquals(productPage.getFirstProductName(),context.get(ContextKeys.PRODUCT_NAME,String.class),"Same Product name is not on the Add to cart page");
    }
}
