package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver) {

        this.driver = driver;
    }

    public void applyLeave() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.xpath("//span[text()='Leave']")));

        driver.findElement(
                By.xpath("//span[text()='Leave']")).click();
    }

    public boolean isLeaveApplied() {

        try {

            return driver.getPageSource()
                    .contains("Leave");

        } catch (Exception e) {

            return false;
        }
    }
}