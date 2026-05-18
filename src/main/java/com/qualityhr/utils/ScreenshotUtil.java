package com.qualityhr.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String name) {

        if(driver == null) {

            System.out.println("Driver is null");

            return name;
        }

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        ts.getScreenshotAs(OutputType.FILE);
        return name;
    }
}