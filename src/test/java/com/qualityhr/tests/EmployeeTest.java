package com.qualityhr.tests;

import com.qualityhr.base.BaseTest;
import com.qualityhr.pages.EmployeePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {

        EmployeePage employee =
                new EmployeePage(driver);

        employee.addEmployee("Priya",
                "S");

        Assert.assertTrue(
                employee.isEmployeeAdded());
    }

    @Test
    public void searchEmployeeTest() {

        EmployeePage employee =
                new EmployeePage(driver);

        employee.searchEmployee("Priya");

        Assert.assertTrue(
                employee.isEmployeeFound("Priya"));

    }
}