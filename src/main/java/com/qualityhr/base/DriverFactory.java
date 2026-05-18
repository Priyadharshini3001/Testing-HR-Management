package com.qualityhr.base;

import com.qualityhr.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initializeDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        return driver;
    }
}