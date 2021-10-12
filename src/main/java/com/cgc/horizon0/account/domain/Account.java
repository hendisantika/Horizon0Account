package com.cgc.horizon0.account.domain;

import javax.json.bind.annotation.JsonbCreator;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cgc.horizon0.account.domain.enumerate.AccountStatus;
import com.cgc.horizon0.account.domain.enumerate.AccountType;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * We are using active record pattern for OR Mapping
 * See https://quarkus.io/guides/hibernate-orm-panache
 * If you want to override id, please extends PanacheEntityBase instead of PanacheEntity
 */
@Entity
public class Account extends PanacheEntity{
    
    public String login_id;
    
    public String login_name;

    @Enumerated(EnumType.STRING)
    public AccountStatus status;

    @Enumerated(EnumType.STRING)
    public AccountType type;

    public Account() {
    }

    public void interalPolicy(String id){
        //business Logic
    }
    private Account(String login_id, String login_name,  AccountType accountType) {
        this.login_id = login_id;
        this.login_name = login_name;
        this.status = AccountStatus.INACTIVATE;
        this.type = accountType;
    }
    private Account(String login_id, String login_name,AccountStatus status,  AccountType accountType) {
        this.login_id = login_id;
        this.login_name = login_name;
        this.status = status;
        this.type = accountType;
    }

    @JsonbCreator
    public static Account of(String login_id, String login_name,  AccountType accountType){
        return new Account(login_id, login_name, accountType);
    }
    
}
