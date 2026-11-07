package pages;

import org.openqa.selenium.By;

public class ShadowDomPage extends BasePage{

    private final By NAME_TEXTBOX = By.cssSelector("#name");
    private final By EMAIL_TEXTBOX = By.cssSelector("#email");
    private final By SUBMIT_TEXTBOX = By.cssSelector("#submitButton");
    private final By SUCCESS_MESSAGE = By.cssSelector("#message");

    public boolean isFormPageDisplayed(){
        return displayed(NAME_TEXTBOX);
    }

    public void enterName(String name){
        type(NAME_TEXTBOX, name);
    }

    public void enterEmail(String email){
        type(EMAIL_TEXTBOX, email);
    }

    public void clicksOnSubmitButton(){
        click(SUBMIT_TEXTBOX);
    }

    public String getSuccessMessage(){
        return text(SUCCESS_MESSAGE);
    }
}
