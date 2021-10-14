package com.cgc.horizon0.account.restapi;

import com.cgc.horizon0.account.service.CommonOpenApisService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/countries")
public class CommonOpenApisCountryResource {

    @Inject
    @RestClient
    CommonOpenApisService commonOpenApisService;

    /**
     * agent calling an api to get payload from another microservice or open API.
     * max retries 3 times.
     * fallbacks on default empty json array payload.
     * @param name - country name in lowercase (e.g. peru)
     * @return List<JsonArray> (CompletionStage - the future of the http api payload)
     */
    @GET
    @Path("/name/{name}")
    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "getCountryDefault")
    public CompletionStage<List<JsonArray>> getCountry(@PathParam("name") String name) {
        return commonOpenApisService.getCountryJsonByName(name);
    }

    /**
     * default empty json array for fallback of get-country-by-name.
     * @param name - @PathParam("name") String name
     * @return List<JsonArray> (CompletionStage - the future of the http api payload)
     */
    public CompletionStage<List<JsonArray>> getCountryDefault(String name) {
        List<JsonArray> defaultRes = new ArrayList<>();
        defaultRes.add(JsonArray.EMPTY_JSON_ARRAY);
        return CompletableFuture.completedStage(defaultRes);
    }
}
