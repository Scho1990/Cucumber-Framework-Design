package pages;

import org.openqa.selenium.By;

public class AddToCartPage extends BasePage{

    private final By CHECKOUT_BTN=By.cssSelector("#checkout");

    public void clicksOnCheckoutButton(){
        click(CHECKOUT_BTN);
    }

}
