package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {

    WebDriver driver;

    public MyInfoPage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    public void openMyInfo() {

        driver.findElement(
                        By.xpath("//span[text()='My Info']"))
                .click();
    }

    public boolean verifyMyInfoPage() {

        return driver.getPageSource()
                .contains("Personal Details");
    }
}