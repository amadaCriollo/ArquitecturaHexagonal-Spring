package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.infrastructure.dto.AccountMovementDto;
import com.bi.account.hexagonal.infrastructure.entities.AccountMovementEntity;
import org.mapstruct.*;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@EnableResourceServer
public interface AccountMovementDtoMapper {

   // AccountMovementDto toDto(AccountMovement accountMovement);



    @Mappings({
            @Mapping(source = "dateCreate", target = "dateCreate",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AccountMovementDto toDomain(AccountMovementEntity accountMovement);

    List<AccountMovementDto> toMovementsAccounts(List<AccountMovementEntity> accountMovementEntityList);

}
