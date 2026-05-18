package com.qualityhr.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.qualityhr.base.DriverFactory;
import com.qualityhr.utils.ExtentManager;
import com.qualityhr.utils.ScreenshotUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(
            ITestResult result) {

        test = extent.createTest(
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        DriverFactory.driver,
                        result.getName()
                );

        test.fail(result.getThrowable());

        try {

            test.addScreenCaptureFromPath(
                    "../" + screenshotPath
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}