package com.bi.account.hexagonal.infrastructure.entities;

import com.bi.account.hexagonal.domain.enums.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String accountNumber;
    @Enumerated(value = EnumType.STRING)
    private TypeAccount typeAccount;

    private BigDecimal totalValue;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_customer_id", nullable = false)
    private CustomerEntity customer;

}
