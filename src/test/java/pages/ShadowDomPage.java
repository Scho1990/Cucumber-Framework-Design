package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage{

    private final By NAME_TEXTBOX = By.cssSelector("#name");
    private final By EMAIL_TEXTBOX = By.cssSelector("#email");
    private final By SUBMIT_TEXTBOX = By.cssSelector("#submitButton");
    private final By SUCCESS_MESSAGE = By.cssSelector("#message");

    public boolean isFormPageDisplayed(){
        return displayed(NAME_TEXTBOX);
    }

    public void enterName(String name){
        WebElement userRegistrationHost = visible(By.cssSelector("div user-registration"));
        SearchContext userRegistrationRoot = userRegistrationHost.getShadowRoot();
        WebElement registrationFormHost = userRegistrationRoot.findElement(By.cssSelector("div registration-form"));
        SearchContext registrationFormRoot = registrationFormHost.getShadowRoot();
        registrationFormRoot.findElement(By.cssSelector("#name")).sendKeys(name);
       // type(NAME_TEXTBOX, name);
    }

    public void enterEmail(String email){
        WebElement userRegistrationHost = visible(By.cssSelector("div user-registration"));
        SearchContext userRegistrationRoot = userRegistrationHost.getShadowRoot();
        WebElement registrationFormHost = userRegistrationRoot.findElement(By.cssSelector("div registration-form"));
        SearchContext registrationFormRoot = registrationFormHost.getShadowRoot();
        registrationFormRoot.findElement(By.cssSelector("#email")).sendKeys(email);
        //type(EMAIL_TEXTBOX, email);
    }

    public void clicksOnSubmitButton(){
        WebElement userRegistrationHost = visible(By.cssSelector("div user-registration"));
        SearchContext userRegistrationRoot = userRegistrationHost.getShadowRoot();
        WebElement registrationFormHost = userRegistrationRoot.findElement(By.cssSelector("div registration-form"));
        SearchContext registrationFormRoot = registrationFormHost.getShadowRoot();
        WebElement formActionsHost = registrationFormRoot.findElement(By.cssSelector("div form-actions"));
        SearchContext formActionsRoot = formActionsHost.getShadowRoot();
        WebElement submitComponentHost = formActionsRoot.findElement(By.cssSelector("div submit-component"));
        SearchContext submitComponentRoot = submitComponentHost.getShadowRoot();
        submitComponentRoot.findElement(By.cssSelector("#submitButton")).click();
       // click(SUBMIT_TEXTBOX);
    }

    public String getSuccessMessage(){
        return text(SUCCESS_MESSAGE);
    }

    private SearchContext shadowRootHandling(String shadowHost, String shadowRoot){
        WebElement userRegistrationHost = visible(By.cssSelector("div user-registration"));
        SearchContext userRegistrationRoot = userRegistrationHost.getShadowRoot();
        WebElement registrationFormHost = userRegistrationRoot.findElement(By.cssSelector("div registration-form"));
        return registrationFormHost.getShadowRoot();
    }
}
