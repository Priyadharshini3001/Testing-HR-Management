package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.EmployeePage;
import com.qualityhr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTest extends BaseTest {

    @Test
    public void verifyEmptyFieldsValidation() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login("Admin",
                "admin123");

        EmployeePage employeePage =
                new EmployeePage(driver);

        employeePage.openPIM();

        employeePage.clickAddEmployee();

        employeePage.clickSave();

        Assert.assertTrue(
                employeePage.isValidationDisplayed(),
                "Validation message is not displayed");
    }
}