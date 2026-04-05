package com.sdet.tests.ui;

import com.sdet.tests.base.BaseTest;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductUITest extends BaseTest {

    @BeforeClass
    public void setupProduct() {
        String body = "{ \"name\": \"iPhone\", \"price\": 999 }";

        RestAssured
                .given()
                .baseUri("http://localhost:8080")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/products");
    }

    @Test
    public void testLoadProducts() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("loadBtn"))).click();

        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("productList"))
        ).getText();

        Assert.assertTrue(text.contains("iPhone"));
    }
}