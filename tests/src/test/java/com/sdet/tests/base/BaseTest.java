package com.sdet.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/dhanu/Desktop/Projects/ecommerce-sdet-demo/frontend/index.html");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}