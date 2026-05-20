package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.EmployeePage;
import com.qualityhr.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        EmployeePage employee =
                new EmployeePage(driver);

        employee.addEmployee("Priya", "S");

        Assert.assertTrue(
                employee.isEmployeeAdded());
    }

    @Test
    public void searchEmployeeTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        EmployeePage employee =
                new EmployeePage(driver);

        // First Add Employee
        employee.addEmployee("Priya", "S");

        // Then Search Employee
        employee.searchEmployee("Priya");

        Assert.assertTrue(
                employee.isEmployeeFound("Priya"));
    }
}