package com.test.blaze.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BlazeTestBase {
    public WebDriver driver;

    @Parameters("url")
    @BeforeMethod
    public void setup(String url) {
        driver = DriverHelper.getDriver();
        driver.get(url);

    }

    @Parameters("packageName")
    @AfterMethod
    public void tearDown(ITestResult iTestResult, String packageName) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenShot(driver, packageName);
        }
        driver.quit();
    }
}
