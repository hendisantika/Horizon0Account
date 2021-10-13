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
    
    public String loginID;
    
    public String loginName;

    @Enumerated(EnumType.STRING)
    public AccountStatus status;

    @Enumerated(EnumType.STRING)
    public AccountType type;

    public Account() {
    }

    public void interalPolicy(String id){
        //business Logic
    }
    private Account(String loginID, String loginName,  AccountType accountType) {
        this.loginID = loginID;
        this.loginName = loginName;
        this.status = AccountStatus.INACTIVATE;
        this.type = accountType;
    }
    private Account(String loginID, String loginName,AccountStatus status,  AccountType accountType) {
        this.loginID = loginID;
        this.loginName = loginName;
        this.status = status;
        this.type = accountType;
    }

    @JsonbCreator
    public static Account of(String loginID, String loginName,  AccountType accountType){
        return new Account(loginID, loginName, accountType);
    }
    
}
