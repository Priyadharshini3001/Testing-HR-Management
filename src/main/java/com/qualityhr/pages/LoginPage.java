package com.qualityhr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By username =
            By.name("username");

    By password =
            By.name("password");

    By loginBtn =
            By.xpath("//button[@type='submit']");

    public void login(String user, String pass) {

        WebElement userField =
                driver.findElement(username);

        userField.clear();
        userField.sendKeys(user);

        WebElement passField =
                driver.findElement(password);

        passField.clear();
        passField.sendKeys(pass);

        driver.findElement(loginBtn).click();
    }
}