package com.bi.account.hexagonal.infrastructure.repositories;

import com.bi.account.hexagonal.infrastructure.entities.AccountMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface JpaAccountMovementsRepository extends JpaRepository<AccountMovementEntity, Long> {

    @Query("select mov from AccountMovementEntity mov where mov.account.customer.identification =?1 and mov.account.accountNumber =?2")
    List<AccountMovementEntity> getMovementsByAccountAndIdentification(String identification, String accountNumber);
    boolean existsByNumTransaction(String numTransaction);
}
