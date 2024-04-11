package com.bi.account.hexagonal.infrastructure.entities;

import com.bi.account.hexagonal.domain.enums.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account_Movement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountMovementEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 50)
    private String numTransaction;

    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    private BigDecimal amount;
    private BigDecimal balance;
    private String description;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TypeTransaction typeTransaction;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="fk_account_id", nullable = false)
    private AccountEntity account;

    @Value("matriz")
    private String agencia;
}
