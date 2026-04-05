package com.sdet.tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CartAPITest {

    @Test
    public void testAddToCart() {
        String body = "{ \"productId\": 1, \"quantity\": 2 }";

        RestAssured
                .given()
                .baseUri("http://localhost:8080")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/cart")
                .then()
                .statusCode(200);
    }
}