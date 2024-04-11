package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.domain.model.User;
import com.bi.account.hexagonal.infrastructure.entities.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class})
public interface UserMapper {

    User toDomain(UserEntity userEntity);
    @InheritInverseConfiguration
    UserEntity toEntity(User user);

}
