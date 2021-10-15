package com.cgc.horizon0.account.integrationtest;

import com.cgc.horizon0.account.domain.AccountInventory;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.wildfly.common.Assert.assertTrue;

/**
 * this case demonstrates an approach of doing TDD.
 * normally for QA testing members who actually know how the business goes and how the payloads would look like.
 */
@QuarkusIntegrationTest
public class AccountInventoryIntegrationTest {

    @InjectMocks
    AccountInventoryService accountInventoryService;

    @Test
    public void testCallInventory() throws Exception {
        JsonObject objectPayload = accountInventoryService.callInventory("xFx9900");
        assertTrue(objectPayload.get("account").toString().equals("BA001"));
    }

    @ApplicationScoped
    private static class AccountInventoryService {
        public JsonObject callInventory(String walletId) {
            String payload = "{'account': 'BA001', 'wallet': 'xFx9900', 'walletSize': 10, 'loanSource': 'CGC', 'loanAmount': 1000.00}";
            return Json.createReader(new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8))).readObject();
        }
    }
}
