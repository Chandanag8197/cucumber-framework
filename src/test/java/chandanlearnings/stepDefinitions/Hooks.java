package chandanlearnings.stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import chandanlearnings.pageObjects.PageObjectManager;
import chandanlearnings.utils.CommonUtils;
import chandanlearnings.utils.testContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    testContext context;

    public Hooks(testContext context) {
        this.context = context;
    }

    @Before
    public void openBrowser() {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties")) {
            Properties prop = new Properties();
            prop.load(fis);

            String URL = prop.getProperty("QAUrl");
            String browserName = prop.getProperty("browser");

            if (context.testBase.getDriver() == null) {
                if (browserName.equalsIgnoreCase("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    context.testBase.setDriver(new ChromeDriver());
                }
                else if (browserName.equalsIgnoreCase("firefox")) {
                    WebDriverManager.chromedriver().setup();
                    context.testBase.setDriver(new FirefoxDriver());
                }

                context.driver = context.testBase.getDriver();
                context.driver.get(URL);
                context.pageObjectManager = new PageObjectManager(context.driver);
                context.commonUtils = new CommonUtils(context.driver);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load browser config from global.properties", e);
        }
    }

    @After
    public void closeBrowser() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    @AfterStep 
    public void addScreenShot(Scenario scenario) throws IOException{

        if(scenario.isFailed()){

        File sourcePath = ((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent, "image/png", "image");

        }

    }
}
