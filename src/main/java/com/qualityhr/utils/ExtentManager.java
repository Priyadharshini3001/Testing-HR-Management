package com.qualityhr.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/QualityHRReport.html"
                    );

            spark.config().setReportName(
                    "QualityHR Automation Report"
            );

            spark.config().setDocumentTitle(
                    "Automation Results"
            );

            extent = new ExtentReports();

            extent.attachReporter(spark);
        }

        return extent;
    }
}