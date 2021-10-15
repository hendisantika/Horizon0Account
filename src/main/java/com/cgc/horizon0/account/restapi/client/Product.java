package com.cgc.horizon0.account.restapi.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : horizon0-account
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/10/21
 * Time: 13.54
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    public Integer id;

    public String name;

    public String description;

    public Product(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product() {
    }
}
