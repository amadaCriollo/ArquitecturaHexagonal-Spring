package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.domain.model.Customer;
import com.bi.account.hexagonal.infrastructure.entities.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer toDomain(CustomerEntity customerEntity);

    @InheritInverseConfiguration
    CustomerEntity toEntity(Customer customer);

    List<Customer> toCustomers(List<CustomerEntity> customerEntityList);
}
