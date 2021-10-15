package com.cgc.horizon0.account.restapi;

import com.cgc.horizon0.account.domain.Account;
import com.cgc.horizon0.account.domain.AccountInventory;
import com.cgc.horizon0.account.domain.enumerate.AccountType;
import com.cgc.horizon0.account.service.AccountInventoryService;
import io.vertx.core.json.Json;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/api/account/inventory")
public class AccountInventoryResource {

    @Inject
    Logger log;

    @Inject
    private AccountInventoryService accountInventoryService;

    /**
     * demonstration on api failing to fallback or timeouts. services retries are configured.
     * @param id - walletId
     * @return AccountInventory object
     * @throws Exception - could be runtime exception
     */
    @GET
    @Path("/{walletId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(30000)
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "wholeAccountDefault")
    public AccountInventory getWholeAccount(@PathParam("walletId") String id) throws Exception {
        log.log(Logger.Level.INFO, String.format("getting whole account: %s", id));
        return accountInventoryService.callInventory(id);
    }

    /**
     * default fallback for 'getWholeAccount'
     * @param id - walletId
     * @return default AccountInventory
     */
    public AccountInventory wholeAccountDefault(String id) {
        return new AccountInventory()
                .withWallet(id)
                .withWalletSize(1)
                .withLoanAmount(new BigDecimal(1000000))
                .withLoanSource("DEFAULT")
                .withAccount(Json.encode(Account.of("DEFAULT", "DEFAULT", AccountType.BRN)));
    }

}
