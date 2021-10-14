package com.cgc.horizon0.account.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/v3.1")
@RegisterRestClient(configKey = "countries-api")
public interface CommonOpenApisService {

    @GET
    @Path("/name/{name}")
    CompletionStage<List<JsonArray>> getCountryJsonByName(@PathParam("name") String name);
}
