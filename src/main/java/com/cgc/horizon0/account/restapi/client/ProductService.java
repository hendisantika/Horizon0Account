package com.cgc.horizon0.account.restapi.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * Created by IntelliJ IDEA.
 * Project : horizon0-account
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/10/21
 * Time: 13.55
 */
@Path("api/v1/products")
@RegisterRestClient(configKey = "product-api")
public interface ProductService {
    @GET
    CompletionStage<List<Product>> getAllProducts();
}
