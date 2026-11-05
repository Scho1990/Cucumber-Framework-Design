package pages;


import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By FIRSTNAME_TEXTBOX = By.cssSelector("#first-name");
    private final By LASTNAME_TEXTBOX = By.cssSelector("#last-name");
    private final By ZIPCODE_TEXTBOX = By.cssSelector("#postal-code");
    private final By CONTINUE_BUTTON = By.cssSelector("#continue");
    private final By FINISH_BUTTON = By.cssSelector("#finish");
    private final By ORDER_SUCCESSFUL_MSG = By.xpath("//h2[@data-test='complete-header']");


    public boolean getCheckoutTitlePage(String title) {
        return displayed(By.xpath("//span[@data-test='title' and normalize-space()='"+title+"']"));
    }

    public void enterCheckoutDetails(String firstName, String lastName, String zipCode){
        type(FIRSTNAME_TEXTBOX, firstName);
        type(LASTNAME_TEXTBOX, lastName);
        type(ZIPCODE_TEXTBOX, zipCode);
    }

    public void clicksOnContinueButton(){
        click(CONTINUE_BUTTON);
    }

    public void clicksOnFinishButton(){
        click(FINISH_BUTTON);
    }

    public String getOrderSuccessMessage(){
        return text(ORDER_SUCCESSFUL_MSG);
    }
}
