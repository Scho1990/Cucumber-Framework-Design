package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager
{

    private DriverManager() {}

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized");
        }
        return driver;
    }

    public static void setDriver(WebDriver driver)
    {
        DRIVER.set(driver);
    }

    public static void quitDriver()
    {
        WebDriver driver = DRIVER.get();
        try {
            if (driver != null) {
                driver.quit();
            }
        }
        finally {
            DRIVER.remove();
        }
    }
}
