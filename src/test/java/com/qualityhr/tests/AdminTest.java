package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.AdminPage;
import com.qualityhr.pages.LoginPage;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void createUserTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        AdminPage adminPage =
                new AdminPage(driver);

        adminPage.openAdmin();
    }
}