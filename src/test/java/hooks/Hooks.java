package hooks;


import config.ConfigManager;
import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 0)
    public void startBrowser()
    {
        DriverFactory.initDriver();
    }

    @Before(order = 1)
    public void openApplication(){
        String url = ConfigManager.getProperty("base.url","");
        if (url.isBlank()){
            throw new IllegalArgumentException("Base URL is empty");
        }
        DriverManager.getDriver().get(url);
    }

    @After(order = 1)
    public void captureFailure(Scenario scenario)
    {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png",scenario.getName());
                scenario.log("Failed URL: "+DriverManager.getDriver().getCurrentUrl());
            } catch (Exception e) {
                scenario.log("Could not capture screenshot: "+e.getMessage());
            }
        }
    }

    @After(order = 0)
    public void closeBrowser()
    {
        DriverManager.getDriver().quit();
    }
}
