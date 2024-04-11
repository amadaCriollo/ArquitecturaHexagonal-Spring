package com.bi.account.hexagonal.application.services;

import com.bi.account.hexagonal.domain.model.Customer;
import com.bi.account.hexagonal.domain.port.CustomerPort;

import java.util.List;

public class CustomerService implements CustomerPort {

    private final CustomerPort customerPort;

    public CustomerService(CustomerPort customerPort) {
        this.customerPort = customerPort;
    }

    @Override
    public Customer save(Customer customer) {
        return customerPort.save(customer);
    }

    @Override
    public List<Customer> getAllsCustomer() {
        return customerPort.getAllsCustomer();
    }
}
