package com.qualityhr.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            reporter.config().setReportName("QualityHR Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            reporter.config().setReportName("QualityHR Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}