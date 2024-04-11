package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.domain.model.AccountMovement;
import com.bi.account.hexagonal.infrastructure.entities.AccountMovementEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMovementMapper {

   // AccountMovementDto toDto(AccountMovement accountMovement);

    @Mappings({
            @Mapping(source = "dateCreate", target = "dateCreate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AccountMovement toDomain(AccountMovementEntity accountMovement);

    @InheritInverseConfiguration
    AccountMovementEntity toEntity(AccountMovement accountMovement);
    @Mappings({
            @Mapping(source = "dateCreate", target = "dateCreate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    List<AccountMovement> toMovementsAccounts(List<AccountMovementEntity> accountMovementEntityList);


    @AfterMapping // or @BeforeMapping
    default void getTotal(AccountMovement account, @MappingTarget AccountMovementEntity dto) {
        dto.setAmount(account.getAmount());
        dto.setBalance(account.getBalance());
    }

    @AfterMapping // or @BeforeMapping
    default void getTotal(AccountMovementEntity accountEntity, @MappingTarget AccountMovement dto) {
        dto.setAmount(accountEntity.getAmount());
        dto.setBalance(accountEntity.getBalance());
    }
}
