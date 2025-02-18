package com.SwagLab_Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listerners implements ITestListener {
	public static WebDriver driver;

    // Called when a test starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    // Called when a test is passed
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    // Called when a test fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        // Take a screenshot or perform any cleanup if necessary
        if (driver != null) {
            // For example, you can capture screenshots or log errors here
            System.out.println("Taking a screenshot for failed test: " + result.getName());
            // Screenshot logic goes here (could be implemented using TakesScreenshot)
        }
    }

    // Called when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    // Called when a test is started (before method execution)
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Can be used if a test fails but within the success percentage
    }

    // Called before the test suite starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    // Called after the test suite finishes
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
        // Close the browser at the end of the suite
        if (driver != null) {
            driver.quit(); // Ensure browser is closed after the suite finishes
        }
    }
}