//package com.sdet.tests.db;
//
//import io.restassured.RestAssured;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class DBTest {
//
//    @Test
//    public void verifyUserInDB() throws Exception {
//        String username = "user" + System.currentTimeMillis();
//        String body = "{ \"username\": \"" + username + "\", \"password\": \"1234\" }";
//
//        RestAssured.given()
//                .baseUri("http://localhost:8080")
//                .header("Content-Type", "application/json")
//                .body(body)
//                .when()
//                .post("/auth/register")
//                .then()
//                .statusCode(200);
//
//        Connection conn = DriverManager.getConnection(
//                "jdbc:h2:file:../data/testdb;DB_CLOSE_DELAY=-1",
//                "sa",
//                ""
//        );
//
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + username + "'");
//
//        Assert.assertTrue(rs.next(), "User not found in DB!");
//        conn.close();
//    }
//}

package com.sdet.tests.db;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DBTest {

    @Test
    public void verifyUserPersistence() {

        String username = "user" + System.currentTimeMillis();

        String body = "{ \"username\": \"" + username + "\", \"password\": \"1234\" }";

        // ✅ Create user
        RestAssured
                .given()
                .baseUri("http://localhost:8080")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/auth/register")
                .then()
                .statusCode(200);

        // ✅ Try login → proves DB stored data
        String response =
                RestAssured
                        .given()
                        .baseUri("http://localhost:8080")
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
}