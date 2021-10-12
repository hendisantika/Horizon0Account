package com.cgc.horizon0.account.restapi;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import com.cgc.horizon0.account.domain.Account;
import com.cgc.horizon0.account.domain.enumerate.AccountType;

@Path("/api/accounts")
public class AccountResource {

    @Inject
    Logger log;


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
    @Path("testerrorhandle")
    @Produces(MediaType.APPLICATION_JSON)
    public Object testErrorHandling(){
        throw new RuntimeException("No one is perfect!");
    }
}
