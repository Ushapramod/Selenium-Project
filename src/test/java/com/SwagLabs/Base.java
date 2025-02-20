package com.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.SwagLab_Utils.TakeScreenShot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.reflect.Method;


public class Base {
    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class);
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;

    @BeforeSuite
    public void setUp() {
        // Define the report path inside the target folder
        String reportPath = "target/ExtentReport.html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.saucedemo.com/");
        log.info("Browser launched and navigated to SwagLabs");
    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName()); // Create test in Extent Report
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            log.error("Test case failed: " + result.getName());
            String screenshotPath = TakeScreenShot.screenShot(driver, result.getName());

            // Log failure message & attach screenshot to Extent Report
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            test.log(Status.PASS, "Test Passed");
        } else {
            test.log(Status.SKIP, "Test Skipped");
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed");
        }
        extent.flush(); // Generate the Extent Report
    }
}
