package com.bi.account.hexagonal.infrastructure.repositories;

import com.bi.account.hexagonal.domain.enums.RoleName;
import com.bi.account.hexagonal.infrastructure.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="roles")
public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {

     Optional<RoleEntity> findByRoleName(RoleName roleName);
}
