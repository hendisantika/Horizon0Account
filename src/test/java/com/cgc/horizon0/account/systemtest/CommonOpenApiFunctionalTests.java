package com.cgc.horizon0.account.systemtest;

import com.cgc.horizon0.account.service.CommonOpenApisService;
import io.quarkus.test.junit.QuarkusTest;
import lombok.SneakyThrows;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.json.JsonArray;

import java.util.List;

import static org.wildfly.common.Assert.assertTrue;

@QuarkusTest
public class CommonOpenApiFunctionalTests {

    @Inject
    @RestClient
    private CommonOpenApisService commonOpenApisService;

    @SneakyThrows
    @Test
    public void testGetCountryByName() {
        assert commonOpenApisService.getCountryJsonByName("peru").toCompletableFuture().isDone();
        List<JsonArray> result = commonOpenApisService.getCountryJsonByName("peru").toCompletableFuture().get();
        assertTrue(result.size() == 1);
        assertTrue(result.get(0).asJsonObject().get("name").asJsonObject().get("common").toString().equals("Peru"));
    }
}
