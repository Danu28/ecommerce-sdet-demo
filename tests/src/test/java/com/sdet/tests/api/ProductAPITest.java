package com.sdet.tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProductAPITest {

    @Test
    public void testGetProducts() {
        RestAssured
                .given()
                .baseUri("http://localhost:8080")
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }
}