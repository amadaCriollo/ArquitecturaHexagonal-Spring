package com.bi.account.hexagonal.domain.port;

import com.bi.account.hexagonal.domain.model.Customer;

import java.util.List;

public interface CustomerPort {
    Customer save(Customer customer);
    List<Customer> getAllsCustomer();
}
