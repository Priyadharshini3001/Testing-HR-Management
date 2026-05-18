package com.qualityhr.pages;

import com.qualityhr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardText;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement profileMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutBtn;

    public boolean isDashboardDisplayed() {

        waitForElement(dashboardText);

        return dashboardText.isDisplayed();
    }

    public void logout() {

        profileMenu.click();

        waitForElement(logoutBtn);

        logoutBtn.click();
    }
}