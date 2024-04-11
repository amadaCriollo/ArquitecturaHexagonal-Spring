package com.bi.account.hexagonal.infrastructure.dto;

import com.bi.account.hexagonal.domain.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EnableResourceServer
public class AccountMovementDto {
    private String numTransaction;
    private Date dateCreate;
    private BigDecimal amount;
    private BigDecimal balance;
    private String description;
    private TypeTransaction typeTransaction;
    private String agencia;

}
