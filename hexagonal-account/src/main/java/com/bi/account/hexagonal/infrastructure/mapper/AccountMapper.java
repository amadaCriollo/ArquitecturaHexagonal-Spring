package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.domain.model.Account;
import com.bi.account.hexagonal.infrastructure.entities.AccountEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CustomerMapper.class})
public interface AccountMapper {

    Account toDomain(AccountEntity accountEntity);
    @InheritInverseConfiguration
    AccountEntity toEntity(Account account);

    @AfterMapping // or @BeforeMapping
    default void getTotal(Account account, @MappingTarget AccountEntity dto) {
        dto.setTotalValue(account.getTotalValue());
    }

    @AfterMapping // or @BeforeMapping
    default void getTotal(AccountEntity accountEntity, @MappingTarget Account dto) {
        dto.setTotalValue(accountEntity.getTotalValue());
    }
    List<Account> toAccounts(List<AccountEntity> accountEntityList);
}
