package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    public void openAdmin() {

        driver.findElement(
                        By.xpath("//span[text()='Admin']"))
                .click();
    }

    public void createUser(
            String role,
            String username,
            String password) {

        driver.findElement(
                        By.xpath("//button[text()=' Add ']"))
                .click();
    }

    public boolean verifyUser(String username) {

        return driver.getPageSource()
                .contains(username);
    }
}