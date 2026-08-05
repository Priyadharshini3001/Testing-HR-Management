package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.EmployeePage;
import com.qualityhr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    @Test(priority = 1)
    public void addEmployeeTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        EmployeePage employeePage = new EmployeePage(driver);

        String firstName = "Priya";
        String lastName = "S";

        employeePage.addEmployee(firstName, lastName);

        Assert.assertTrue(
                employeePage.isEmployeeAdded(),
                "Employee was not added successfully!"
        );
    }

    @Test(priority = 2)
    public void searchEmployeeTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        EmployeePage employeePage = new EmployeePage(driver);

        String firstName = "Priya";
        String lastName = "S";

        employeePage.addEmployee(firstName, lastName);

        employeePage.searchEmployee(firstName);

        Assert.assertTrue(
                employeePage.isEmployeeFound(firstName),
                "Employee search failed!"
        );
    }
}