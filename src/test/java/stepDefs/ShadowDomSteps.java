package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ShadowDomPage;

public class ShadowDomSteps {
    ShadowDomPage shadowDomPage;
    public ShadowDomSteps(){
        shadowDomPage = new ShadowDomPage();
    }

    @Given("User is on Form page")
    public void user_is_on_form_page() {
        Assert.assertTrue(shadowDomPage.isFormPageDisplayed(), "Form page is not displayed");
    }

    @When("User enters the below details in form")
    public void user_enters_the_below_details_in_form(DataTable dataTable) {

    }

    @When("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        Assert.assertEquals( shadowDomPage.getSuccessMessage(),"Form submitted successfully!","Success message is not displayed");
    }

    @Then("User should see the success message")
    public void user_should_see_the_success_message() {

    }
}
