package com.bi.account.hexagonal.infrastructure.adapters;

import com.bi.account.hexagonal.domain.model.Customer;
import com.bi.account.hexagonal.domain.port.CustomerPort;
import com.bi.account.hexagonal.infrastructure.entities.CustomerEntity;
import com.bi.account.hexagonal.infrastructure.mapper.CustomerMapper;
import com.bi.account.hexagonal.infrastructure.repositories.JpaCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerPort {

    private final JpaCustomerRepository jpaCustomerRepository;
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = jpaCustomerRepository.findByIdentification(customer.getIdentification());
        if(customerEntity != null) {
            return customerMapper.toDomain(customerEntity);
        }
        CustomerEntity savedCustomerEntity = jpaCustomerRepository.save(customerMapper.toEntity(customer));
        return customerMapper.toDomain(savedCustomerEntity);
    }

    @Override
    public List<Customer> getAllsCustomer() {
        return customerMapper.toCustomers(jpaCustomerRepository.findAll());
    }
}
