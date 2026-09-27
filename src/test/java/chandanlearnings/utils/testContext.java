package chandanlearnings.utils;

import org.openqa.selenium.WebDriver;

import chandanlearnings.pageObjects.PageObjectManager;

public class testContext {


    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    public PageObjectManager pageObjectManager;
    public CommonUtils commonUtils;
    public TestBase testBase;

    public testContext() {

        testBase = new TestBase();





    }

}
