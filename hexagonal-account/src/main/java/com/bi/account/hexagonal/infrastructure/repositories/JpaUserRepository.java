package com.bi.account.hexagonal.infrastructure.repositories;

import com.bi.account.hexagonal.infrastructure.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path="users")
public interface JpaUserRepository extends CrudRepository<UserEntity, Long> {

     @RestResource(path = "getByUsername")
     Optional<UserEntity> findByUsername(@Param("name") String username);
}
