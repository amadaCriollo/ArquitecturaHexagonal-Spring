package com.bi.account.hexagonal.infrastructure.adapters.service;

import com.bi.account.hexagonal.infrastructure.dto.AccountMovementDto;
import com.bi.account.hexagonal.infrastructure.entities.AccountMovementEntity;
import com.bi.account.hexagonal.infrastructure.mapper.AccountMovementDtoMapper;
import com.bi.account.hexagonal.infrastructure.repositories.JpaAccountMovementsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableResourceServer
public class ListAccountMovementService {
    private final JpaAccountMovementsRepository jpaAccountMovementsRepository;
    @Autowired
    private AccountMovementDtoMapper mapperMapper;
    @Value("${bi.agencia}")
    private String agencia;

    public List<AccountMovementDto> getMovementByAccountAndCustomer(String identification, String accountNumber) {
        AccountMovementDto dto = new AccountMovementDto();
        List<AccountMovementEntity> list = jpaAccountMovementsRepository.getMovementsByAccountAndIdentification(identification,accountNumber);
        list.stream().peek(movement -> movement.setAgencia(agencia)).collect(Collectors.toList());
        return mapperMapper.toMovementsAccounts(list);
    }
}
