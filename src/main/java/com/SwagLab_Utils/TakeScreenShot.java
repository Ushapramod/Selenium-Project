package com.SwagLab_Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class TakeScreenShot {

    // Method to take screenshot and return the screenshot path
    public static String screenShot(WebDriver driver, String testName) {
        String photoPath = "target/screenshots/"; // Specify the folder where screenshots will be saved

        // Ensure the folder exists
        File directory = new File(photoPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create folder if it doesn't exist
        }

        // Format timestamp to avoid file name collisions
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".jpeg"; // Name the screenshot file

        // Take screenshot
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);

        // Define destination file where screenshot will be saved
        File destination = new File(photoPath + screenshotName);

        try {
            // Copy screenshot to the specified location
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        // Return the absolute path of the screenshot
        return destination.getAbsolutePath();
    }
}
