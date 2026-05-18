package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver) {

        this.driver = driver;
    }

    By leaveMenu =
            By.xpath("//span[text()='Leave']");

    By applyLink =
            By.xpath("//a[text()='Apply']");

    By commentBox =
            By.xpath("//textarea");

    By applyBtn =
            By.xpath("//button[@type='submit']");

    public void applyLeave() {

        driver.findElement(leaveMenu).click();

        driver.findElement(applyLink).click();

        driver.findElement(commentBox)
                .sendKeys("Leave Request");

        driver.findElement(applyBtn).click();
    }

    public boolean isLeaveApplied() {

        return driver.getPageSource()
                .contains("Success");
    }
}