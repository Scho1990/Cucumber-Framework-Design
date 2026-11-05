package driver;

import config.ConfigManager;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory
{

    private DriverFactory() {}

    public static void initDriver()
    {
        String browser = ConfigManager.getProperty("browser","chrome").trim().toLowerCase();
        boolean headless = ConfigManager.getBoolean("headless",false);
        String executionType = ConfigManager.getProperty("executionType","local").trim().toLowerCase();
        WebDriver driver = switch (executionType) {
            case "local" -> createLocalDriver(browser, headless);
            case "remote" -> createRemoteDriver(browser, headless);
            default -> throw new IllegalArgumentException("Unsupported execution type: " + executionType);
        };
        DriverManager.setDriver(driver);
    }

    private static WebDriver createLocalDriver(String browser, boolean headless)
    {
        return switch (browser){
            case "chrome" -> new ChromeDriver(createChromeOptions(headless));
            case "firefox" -> new FirefoxDriver(createFirefoxOptions(headless));
            case "edge" -> new EdgeDriver(createEdgeOptions(headless));
            default -> throw new IllegalStateException("Unsupported browser"+ browser);
        };
    }

    private static WebDriver createRemoteDriver(String browser, boolean headless)
    {
        String gridURL = ConfigManager.getProperty("gridURL","http://localhost:4444/wd/hub");
        try {
            URL remoteURL = new URL(gridURL);
            return switch (browser){
                case "chrome" -> new RemoteWebDriver(remoteURL, createChromeOptions(headless));
                case "firefox" -> new RemoteWebDriver(remoteURL, createFirefoxOptions(headless));
                case "edge" -> new RemoteWebDriver(remoteURL, createEdgeOptions(headless));
                default -> throw new IllegalStateException("Unsupported browser"+ browser);
            };
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid Selenium Grid URL: " + gridURL, e);
        }
    }

    private static @NonNull ChromeOptions createChromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1440,1000", "--disable-notifications");
        // Disable Chrome password manager
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Disable password leak detection
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static @NonNull FirefoxOptions createFirefoxOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        FirefoxProfile profile = new FirefoxProfile();

        // Disable saving passwords
        profile.setPreference("signon.rememberSignons", false);

        // Disable breach alerts
        profile.setPreference(
                "signon.management.page.breach-alerts.enabled", false
        );

        // Disable password manager UI
        profile.setPreference(
                "signon.management.page.showPassword", false
        );

        options.setProfile(profile);
        return options;
    }

    // Edge options
    private static EdgeOptions createEdgeOptions(boolean headless) {

        EdgeOptions options = new EdgeOptions();

        options.addArguments(
                "--window-size=1440,1000",
                "--disable-notifications"
        );

        if (headless) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
