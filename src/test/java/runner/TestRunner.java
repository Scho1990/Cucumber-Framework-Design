package runner;

/*import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;*/

// cucumber-testng is deprecated from November 2026
/*@CucumberOptions(
features = "src/test/resources/features/",
        glue = {"stepDefs","hooks"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "rerun:target/failed-scenarios.txt"},
        monochrome = true,
        //tags = "@product",
        dryRun = false,
        publish = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenario() {
        return super.scenarios();
    }

}*/


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "stepDefs,hooks"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty,html:target.cucumber.html"
)
/*@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value =""
)*/
public class TestRunner
{

}
