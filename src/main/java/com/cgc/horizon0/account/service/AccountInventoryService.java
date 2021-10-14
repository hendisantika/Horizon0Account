package com.cgc.horizon0.account.service;

import com.cgc.horizon0.account.domain.Account;
import com.cgc.horizon0.account.domain.AccountInventory;
import com.cgc.horizon0.account.domain.enumerate.AccountType;
import io.vertx.core.json.Json;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class AccountInventoryService {

    /**
     * demo chances of reaction
     * @param walletId - key for payload
     * @return AccountInventory object
     * @throws Exception - runtime
     */
    @CircuitBreaker(requestVolumeThreshold = 3)
    @Retry(maxRetries = 3)
    public AccountInventory callInventory(String walletId) throws Exception {
        AccountInventory ai = new AccountInventory()
                .withWallet(walletId)
                .withWalletSize(1);
        return CallInventoryMocker.callData(ai);
    }
}

/**
 * this mocker is a demo when in this service you have to call an API within another service.
 * this could be restful HTTP or message brokers.
 */
class CallInventoryMocker {

    /**
     * this would mock the restful api call for the data
     * @param ai - filter entity
     * @return data
     */
    public static AccountInventory callData(AccountInventory ai) throws Exception {
        if (System.currentTimeMillis() % 4 == 0 || System.currentTimeMillis() % 7 == 0) throw new RuntimeException("api connection lost");
        if (System.currentTimeMillis() % 3 == 0) Thread.sleep(120 * 1000);
        return new AccountInventory()
                .withWallet(ai.getWallet())
                .withWalletSize(ai.getWalletSize())
                .withLoanAmount(new BigDecimal(1000000))
                .withLoanSource("CGC")
                .withAccount(Json.encode(Account.of("QWE", "USER", AccountType.BRN)));
    }
}
