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

    By adminMenu =
            By.xpath("//span[text()='Admin']");

    public void openAdmin() {

        driver.findElement(adminMenu).click();
    }
}