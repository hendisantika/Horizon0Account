package com.cgc.horizon0.account.restapi;

import com.cgc.horizon0.account.domain.Account;
import com.cgc.horizon0.account.domain.enumerate.AccountType;
import com.cgc.horizon0.account.restapi.client.Product;
import com.cgc.horizon0.account.restapi.client.ProductService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/api/accounts")
public class AccountResource {

    @Inject
    Logger log;

    @Inject
    @RestClient
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Account greeting() {
        Account newAccount = Account.of("ryanzhang", "Ryan Zhang", AccountType.NRIC);
        newAccount.persist();
        log.info("A new Account created!");
        return newAccount;
    }

    @GET
    @Path("/all")
    public List<Account> listAccounts() {
        return Account.listAll();
    }

    @GET
    @Path("testerrorhandle")
    @Produces(MediaType.APPLICATION_JSON)
    public Object testErrorHandling() {
        throw new RuntimeException("No one is perfect!");
    }

    @GET
    @Path("/products")
    public CompletionStage<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }
}
