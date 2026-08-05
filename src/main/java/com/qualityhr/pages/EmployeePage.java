package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeePage {

    WebDriver driver;
    WebDriverWait wait;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ===========================
    // Locators
    // ===========================

    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    By firstNameField = By.name("firstName");
    By lastNameField = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
    By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");
    By loader = By.cssSelector(".oxd-form-loader");

    By searchEmployeeBox =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    By searchButton =
            By.xpath("//button[@type='submit']");

    By tableBody =
            By.xpath("//div[@class='oxd-table-body']");

    By tableRows =
            By.xpath("//div[@class='oxd-table-card']");

    By validationMessage =
            By.xpath("//span[text()='Required']");

    // ===========================
    // PIM
    // ===========================

    public void openPIM() {

        wait.until(ExpectedConditions.elementToBeClickable(pimMenu));

        driver.findElement(pimMenu).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    // ===========================
    // Add Employee
    // ===========================

    public void clickAddEmployee() {

        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeBtn));

        driver.findElement(addEmployeeBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    public void enterFirstName(String firstName) {

        WebElement firstNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

        firstNameElement.clear();

        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        WebElement lastNameElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));

        lastNameElement.clear();

        lastNameElement.sendKeys(lastName);
    }

    public void clickSave() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        WebElement saveButton =
                wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

        try {

            saveButton.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", saveButton);
        }
    }

    public void addEmployee(String firstName, String lastName) {

        openPIM();

        clickAddEmployee();

        enterFirstName(firstName);

        enterLastName(lastName);

        clickSave();
    }

    // ===========================
    // Verify Employee Added
    // ===========================

    public boolean isEmployeeAdded() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));

            return driver.findElement(personalDetailsHeader).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // ===========================
    // Search Employee
    // ===========================

    public void searchEmployee(String employeeName) {

        openPIM();

        WebElement searchBox =
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeBox));

        searchBox.clear();

        searchBox.sendKeys(employeeName);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
    }

    // ===========================
    // Verify Employee Found
    // ===========================

    public boolean isEmployeeFound(String employeeName) {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(tableRows));

            List<WebElement> rows = driver.findElements(tableRows);

            for (WebElement row : rows) {

                if (row.getText().contains(employeeName)) {

                    return true;
                }
            }

            return false;

        } catch (Exception e) {

            return false;
        }
    }

    // ===========================
    // Validation Message
    // ===========================

    public boolean isValidationDisplayed() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage));

            return driver.findElement(validationMessage).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}