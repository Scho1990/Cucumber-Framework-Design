package utils;

import config.ConfigManager;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public final class Waits {
    private Waits() {}

    private static WebDriverWait waitFor() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigManager.getInt("explicit.wait.seconds", 15)));
    }
    public static WebElement visible(By locator) { return waitFor().until(ExpectedConditions.visibilityOfElementLocated(locator)); }

    public static List<WebElement> presenceOfAllElements(By locator) {
        return waitFor().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static WebElement clickable(By locator) { return waitFor().until(ExpectedConditions.elementToBeClickable(locator)); }

    public static boolean urlContains(String text) { return waitFor().until(ExpectedConditions.urlContains(text)); }

    public static Boolean inVisible(By locator) {
        return waitFor().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}

