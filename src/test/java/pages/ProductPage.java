package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private final By PRODUCT_PAGE_TITLE = By.xpath("//span[@data-test='title']");
    private final By PRODUCT_NAMES = By.xpath("//div[@data-test='inventory-item-name']");
    private final By ADD_TO_CART_BTN= By.xpath("//button[contains(@id,'add-to-cart')]");
    private final By CART_ICON= By.xpath("//a[@data-test='shopping-cart-link']");
    private final By CART_PRODUCT_COUNT= By.xpath("//a[@data-test='shopping-cart-link']//span");


    public boolean isProductPageTitleDisplayed() {
        return displayed(PRODUCT_PAGE_TITLE);
    }

    public String getFirstProductName() {
        return alwaysReturnFirstProductNameIfPresent(PRODUCT_NAMES).getText();
    }

    public void clicksOnAddToCartButton(){
        alwaysReturnFirstProductNameIfPresent(ADD_TO_CART_BTN).click();
    }

    public String buttonChangedToRemoved(String productName){
        By locator = By.xpath(" //div[normalize-space()='"+productName+"']/../../following-sibling::div//button[contains(@id,'remove')]");
        return text(locator);
    }

    public Integer productCountOnCartIcon(){
        return Integer.parseInt(text(CART_PRODUCT_COUNT));
    }

    public void clickOnCartIcon(){
        click(CART_ICON);
    }


    private WebElement alwaysReturnFirstProductNameIfPresent(By locator) {
      return presenceOfAllElements(locator).getFirst();
    }


}
