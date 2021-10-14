package com.cgc.horizon0.account.unittest.loadconfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class LoadAppConfigTest {

    @ConfigProperty(name = "rhsso.client_credential")
    String client_credential;

    @ConfigProperty(name = "my_another_variable")
    String my_another_variable;

    @Test
    void readMyCustomizeProperty(){
        assertEquals(client_credential, "verysecurepassword");    
        assertEquals(my_another_variable, "awesomeparameter");
    }
}
