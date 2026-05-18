package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.LeavePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {

    @Test
    public void applyLeaveTest() {

        LeavePage leave =
                new LeavePage(driver);

        leave.applyLeave();

        Assert.assertTrue(
                leave.isLeaveApplied());
    }
}