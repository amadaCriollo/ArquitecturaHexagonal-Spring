package com.bi.account.hexagonal.infrastructure.repositories;

import com.bi.account.hexagonal.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select cus from CustomerEntity cus where cus.identification =?1")
    public boolean existCustomer(String identification);

    public CustomerEntity findByIdentification(String identification);
}
