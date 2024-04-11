package com.bi.account.hexagonal.infrastructure.mapper;

import com.bi.account.hexagonal.domain.model.Role;
import com.bi.account.hexagonal.infrastructure.entities.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    Role toDomain(RoleEntity roleEntity);
    @InheritInverseConfiguration
    RoleEntity toEntity(Role role);

}
