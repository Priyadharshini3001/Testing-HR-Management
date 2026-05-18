package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    WebDriver driver;

    public EmployeePage(WebDriver driver) {

        this.driver = driver;
    }

    By pimMenu =
            By.xpath("//span[text()='PIM']");

    By addEmployeeBtn =
            By.xpath("//a[text()='Add Employee']");

    By firstName =
            By.name("firstName");

    By lastName =
            By.name("lastName");

    By saveBtn =
            By.xpath("//button[@type='submit']");

    By employeeList =
            By.xpath("//a[text()='Employee List']");

    By searchBox =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    By searchBtn =
            By.xpath("//button[@type='submit']");

    public void addEmployee(String fName,
                            String lName) {

        driver.findElement(pimMenu).click();

        driver.findElement(addEmployeeBtn).click();

        driver.findElement(firstName).sendKeys(fName);

        driver.findElement(lastName).sendKeys(lName);

        driver.findElement(saveBtn).click();
    }

    public boolean isEmployeeAdded() {

        return driver.getPageSource()
                .contains("Personal Details");
    }

    public void searchEmployee(String name) {

        driver.findElement(pimMenu).click();

        driver.findElement(employeeList).click();

        driver.findElement(searchBox).sendKeys(name);

        driver.findElement(searchBtn).click();
    }
    public boolean isValidationDisplayed() {
        return driver.getPageSource()
                .contains("Required");
    }

    public void openPIM() {

        driver.findElement(pimMenu)
                .click();
    }

    public void clickAddEmployee() {

        driver.findElement(addEmployeeBtn)
                .click();
    }

    public void clickSave() {

        driver.findElement(saveBtn)
                .click();
    }


    public boolean isEmployeeFound(String name) {

        return driver.getPageSource()
                .contains(name);
    }
}