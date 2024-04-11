package com.bi.account.hexagonal.infrastructure.adapters;

import com.bi.account.hexagonal.domain.enums.RoleName;
import com.bi.account.hexagonal.infrastructure.dto.MessageDto;
import com.bi.account.hexagonal.infrastructure.dto.UserDto;
import com.bi.account.hexagonal.infrastructure.entities.RoleEntity;
import com.bi.account.hexagonal.infrastructure.entities.UserEntity;
import com.bi.account.hexagonal.infrastructure.mapper.UserMapper;
import com.bi.account.hexagonal.infrastructure.repositories.JpaRoleRepository;
import com.bi.account.hexagonal.infrastructure.repositories.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JpaUserRepositoryAdapter {

    private final JpaUserRepository jpaUserRepository;
    private final JpaRoleRepository jpaRoleRepository;
    @Autowired
    private UserMapper userMapper;

   // private final PasswordEncoder passwordEncoder;
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

    public MessageDto save(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .username(userDto.username())
                .password(passwordEncoder.encode(userDto.password()))
                .build();
        Set<RoleEntity> roles = new HashSet<>();
        userDto.roles().forEach(r -> {
            RoleEntity role = jpaRoleRepository.findByRoleName(RoleName.valueOf(r))
                    .orElseThrow(() -> new RuntimeException("No existe el rol"));
            roles.add(role);
        });
        userEntity.setRoles(roles);
        jpaUserRepository.save(userEntity);
        return new MessageDto("user " + userEntity.getUsername() + " guardado");
    }
//    public User save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        UserEntity userEntity = jpaUserRepository.save(userMapper.toEntity(user));
//        return userMapper.toDomain(userEntity);
//    }
}
