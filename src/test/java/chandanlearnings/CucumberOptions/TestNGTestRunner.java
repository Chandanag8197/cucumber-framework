package chandanlearnings.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/chandanlearnings/features",
    glue = "chandanlearnings.stepDefinitions",
    monochrome = true,
    plugin = {
        "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] parallelTest() {
        return super.scenarios();
    }
}
