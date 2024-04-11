package com.bi.account.hexagonal.domain.model;

import com.bi.account.hexagonal.domain.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountMovement {
    private Long id;
    private String numTransaction;
    private Date dateCreate;
    private BigDecimal amount;
    private BigDecimal balance;
    private String description;
    private TypeTransaction typeTransaction;
    private Account account;
}
