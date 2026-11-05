package stepDefs;

import config.ConfigManager;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;

public class LoginSteps {
 LoginPage loginPage ;
 ProductPage productPage ;
 private final TestContext context;

   public LoginSteps(TestContext context) {
       loginPage = new LoginPage();
       productPage = new ProductPage();
       this.context = context;
    }


    @Given("User is on login page")
    public void user_is_on_login_page() {
        Assert.assertTrue(loginPage.isUserLandedOnLoginPage(),"User is not on the login page");

    }

    @When("User enters valid Username and Password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUserName(ConfigManager.getProperty("username","standard_user"));
        loginPage.enterPassword(ConfigManager.getProperty("user.password",""));
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User is successfully landed on home screen page")
    public void user_is_successfully_landed_on_home_screen_page() {
         Assert.assertTrue(productPage.isProductPageTitleDisplayed(),"User is not on the Product page");
    }
}
