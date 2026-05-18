package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.AdminPage;
import com.qualityhr.pages.LoginPage;
import com.qualityhr.utils.ConfigReader;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void createUserTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        AdminPage adminPage =
                new AdminPage(driver);

        adminPage.openAdmin();
    }
}