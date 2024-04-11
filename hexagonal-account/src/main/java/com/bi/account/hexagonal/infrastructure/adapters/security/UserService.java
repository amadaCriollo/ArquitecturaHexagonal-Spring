package com.bi.account.hexagonal.infrastructure.adapters.security;

import com.bi.account.hexagonal.infrastructure.adapters.service.IuserService;
import com.bi.account.hexagonal.infrastructure.entities.UserEntity;
import com.bi.account.hexagonal.infrastructure.repositories.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IuserService, UserDetailsService {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = jpaUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
        List<GrantedAuthority> authorities = userEntity.getRoles()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleName().toString()))
                .peek(authority -> log.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        log.info("Usuario autenticado: " + username);
        return new User(userEntity.getUsername(),userEntity.getPassword(),userEntity.isEnabled(),true,
                true,true, authorities);
    }

    @Override
    public <Optional>UserEntity loadByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
    }
}
