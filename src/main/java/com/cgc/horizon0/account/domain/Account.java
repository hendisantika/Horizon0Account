package com.cgc.horizon0.account.domain;

import com.cgc.horizon0.account.domain.enumerate.AccountStatus;
import com.cgc.horizon0.account.domain.enumerate.AccountType;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * We are using active record pattern for OR Mapping
 * See https://quarkus.io/guides/hibernate-orm-panache
 * If you want to override id, please extends PanacheEntityBase instead of PanacheEntity
 */
@Entity
@Table(name = "account", schema = "account")
public class Account extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "login_id")
    public String loginId;

    @Column(name = "login_name")
    public String loginName;

    @Column(name = "account_status")
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
        this.loginId = loginID;
        this.loginName = loginName;
        this.status = AccountStatus.INACTIVATE;
        this.type = accountType;
    }
    private Account(String loginID, String loginName,AccountStatus status,  AccountType accountType) {
        this.loginId = loginID;
        this.loginName = loginName;
        this.status = status;
        this.type = accountType;
    }

    @JsonbCreator
    public static Account of(String loginID, String loginName,  AccountType accountType){
        return new Account(loginID, loginName, accountType);
    }
    
}
