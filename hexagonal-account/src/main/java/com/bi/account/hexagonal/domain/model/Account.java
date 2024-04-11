package com.bi.account.hexagonal.domain.model;

import com.bi.account.hexagonal.domain.enums.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Long id;
    private String accountNumber;
    private TypeAccount typeAccount;
    private BigDecimal totalValue;
    private Customer customer;

}
