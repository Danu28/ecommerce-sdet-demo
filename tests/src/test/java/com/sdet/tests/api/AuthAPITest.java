package com.sdet.tests.api;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthAPITest {

    private final String BASE_URL = "http://localhost:8080";

    private String username;

    @BeforeClass
    public void setupUser() {
        username = "user" + System.currentTimeMillis();

        String body = "{ \"username\": \"" + username + "\", \"password\": \"1234\" }";

        RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/auth/register");
    }

    @Test
    public void testLoginSuccess() {
        String body = "{ \"username\": \"" + username + "\", \"password\": \"1234\" }";

        String response =
                RestAssured
                        .given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/auth/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        Assert.assertEquals(response, "SUCCESS");
    }

    @Test
    public void testLoginFailure() {
        String body = "{ \"username\": \"testuser\", \"password\": \"wrong\" }";

        String response =
                RestAssured
                        .given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/auth/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();

        Assert.assertEquals(response, "FAIL");
    }
}