package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import utils.Waits;

import java.util.List;

public abstract class BasePage {
    protected WebElement visible(By locator) {
        return Waits.visible(locator);
    }

    protected List<WebElement> presenceOfAllElements(By locator) {
        return Waits.presenceOfAllElements(locator);
    }

    protected WebElement clickable(By locator) {
        return Waits.clickable(locator);
    }

    protected void click(By locator) {
        clickable(locator).click();
    }

    protected void type(By locator, String value) {
        WebElement element = visible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String text(By locator) {
        return visible(locator).getText().trim();
    }

    protected boolean displayed(By locator) {
        try {
            return visible(locator).isDisplayed();
        } catch (RuntimeException e) {
            return false;
        }
    }

    protected void pressEnter(By locator) {
        visible(locator).sendKeys(Keys.ENTER);
    }

    protected String attribute(By locator, String name) {
        return visible(locator).getAttribute(name);
    }

    public String currentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}

