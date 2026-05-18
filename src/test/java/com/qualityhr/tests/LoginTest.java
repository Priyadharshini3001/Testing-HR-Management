package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.LoginPage;
import com.qualityhr.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test

    public void loginTest() throws InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        Thread.sleep(3000);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Thread.sleep(5000);

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("dashboard")
        );
    }
}