package com.bi.account.hexagonal.infrastructure.repositories;

import com.bi.account.hexagonal.infrastructure.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, Long> {
    @Query("select account from AccountEntity account where account.customer.identification =?1")
    List<AccountEntity> getAccountsByCustomer(String identification);

    public boolean existsByAccountNumber(String accountNumber);

    public AccountEntity findByAccountNumber(String accountNumber);
}
