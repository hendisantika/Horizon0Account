package com.cgc.horizon0.account.integrationtest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class AccountResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/accounts")
                .then()
                .statusCode(200)
                .body("loginName", equalTo("Ryan Zhang"));
    }

}
