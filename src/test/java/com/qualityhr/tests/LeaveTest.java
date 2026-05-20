package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.LeavePage;
import com.qualityhr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @Test
    public void applyLeaveTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        LeavePage leave =
                new LeavePage(driver);

        leave.applyLeave();

        Assert.assertTrue(
                leave.isLeaveApplied());
    }
}