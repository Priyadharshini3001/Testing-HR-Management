package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeePage {

    WebDriver driver;

    public EmployeePage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    By firstNameField = By.name("firstName");
    By lastNameField = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
    By personalDetailsHeader =
            By.xpath("//h6[text()='Personal Details']");

    // Open PIM
    public void openPIM() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(pimMenu));

        driver.findElement(pimMenu).click();
    }

    // Click Add Employee
    public void clickAddEmployee() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .elementToBeClickable(addEmployeeBtn));

        driver.findElement(addEmployeeBtn).click();
    }

    // Enter First Name
    public void enterFirstName(String firstName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstNameField));

        driver.findElement(firstNameField)
                .sendKeys(firstName);
    }

    // Enter Last Name
    public void enterLastName(String lastName) {

        driver.findElement(lastNameField)
                .sendKeys(lastName);
    }

    // Click Save
    public void clickSave() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .elementToBeClickable(saveBtn));

        driver.findElement(saveBtn).click();
    }

    // Add Employee Full Flow
    public void addEmployee(String firstName,
                            String lastName) {

        openPIM();

        clickAddEmployee();

        enterFirstName(firstName);

        enterLastName(lastName);

        clickSave();
    }

    // Verify Employee Added
    public boolean isEmployeeAdded() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(20));

            WebElement personalDetails = wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    personalDetailsHeader));

            return personalDetails.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Search Employee
    public void searchEmployee(String employeeName) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        openPIM();

        WebElement searchBox = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(
                                By.xpath("(//input[@placeholder='Type for hints...'])[1]")));

        searchBox.clear();

        searchBox.sendKeys(employeeName);

        wait.until(ExpectedConditions
                        .elementToBeClickable(saveBtn))
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//div[@class='oxd-table-body']")));
    }

    // Verify Employee Found
    public boolean isEmployeeFound(String employeeName) {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(20));

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            By.xpath("//div[@class='oxd-table-card']")));

            List<WebElement> rows =
                    driver.findElements(
                            By.xpath("//div[@class='oxd-table-card']"));

            for (WebElement row : rows) {

                if (row.getText()
                        .contains(employeeName)) {

                    return true;
                }
            }

            return false;

        } catch (Exception e) {

            return false;
        }
    }

    // Validation Message
    public boolean isValidationDisplayed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(20));

            WebElement validationMessage = wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(
                                    By.xpath("//span[text()='Required']")));

            return validationMessage.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}