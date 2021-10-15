package com.cgc.horizon0.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountInventory extends PanacheEntity {
    private String account;
    private String wallet;
    private int walletSize;
    private String loanSource;
    private BigDecimal loanAmount;
}
