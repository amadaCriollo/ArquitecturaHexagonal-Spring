package com.bi.account.hexagonal.infrastructure.adapters;

import com.bi.account.hexagonal.domain.enums.TypeTransaction;
import com.bi.account.hexagonal.domain.model.AccountMovement;
import com.bi.account.hexagonal.domain.port.AccountMovementPort;
import com.bi.account.hexagonal.infrastructure.dto.AccountMovementDto;
import com.bi.account.hexagonal.infrastructure.entities.AccountEntity;
import com.bi.account.hexagonal.infrastructure.entities.AccountMovementEntity;
import com.bi.account.hexagonal.infrastructure.exceptions.DuplicateEntityException;
import com.bi.account.hexagonal.infrastructure.exceptions.NotFoundException;
import com.bi.account.hexagonal.infrastructure.mapper.AccountMapper;
import com.bi.account.hexagonal.infrastructure.mapper.AccountMovementDtoMapper;
import com.bi.account.hexagonal.infrastructure.mapper.AccountMovementMapper;
import com.bi.account.hexagonal.infrastructure.repositories.JpaAccountMovementsRepository;
import com.bi.account.hexagonal.infrastructure.repositories.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JpaAccountMovementRepositoryAdapter implements AccountMovementPort {

    private final JpaAccountMovementsRepository jpaAccountMovementsRepository;
    private final JpaAccountRepository jpaAccountRepository;

    @Autowired
    private AccountMovementMapper movementMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountMovementDtoMapper movementDtoMapper;

    @Override
    public AccountMovement save(AccountMovement accountMovement) throws NotFoundException, DuplicateEntityException {
        accountMovement.setDateCreate(new Date());
        AccountEntity accountEntity = jpaAccountRepository.findByAccountNumber(accountMovement.getAccount().getAccountNumber());
        if(accountEntity == null){
            throw new NotFoundException("Cuenta no existe");
        }
        accountMovement.setBalance(accountEntity.getTotalValue());
        if(jpaAccountMovementsRepository.existsByNumTransaction(accountMovement.getNumTransaction())) {
            throw  new DuplicateEntityException("Número de transacción ya existe");
        }

        accountMovement.setBalance(accountEntity.getTotalValue());
        BigDecimal balance = new BigDecimal(0.0);
        System.out.println("typeTrassaction--> " + accountMovement.getTypeTransaction());
        if(TypeTransaction.valueOf("INGRESO").equals(accountMovement.getTypeTransaction())) {
            balance = accountEntity.getTotalValue().add(accountMovement.getAmount());
            System.out.println("balance--> " + balance);
        }else {
            balance = accountEntity.getTotalValue().subtract(accountMovement.getAmount());
        }
        accountEntity.setTotalValue(balance);
        AccountMovementEntity accountMovementEntity = movementMapper.toEntity(accountMovement);
        accountMovementEntity.setAccount(accountEntity);
        AccountMovementEntity saveAccountMovement = jpaAccountMovementsRepository.save(accountMovementEntity);
        return movementMapper.toDomain(saveAccountMovement);
    }


    public List<AccountMovementDto> getMovementByAccountAndCustomer(String identification, String accountNumber) {
        return movementDtoMapper.toMovementsAccounts(jpaAccountMovementsRepository.getMovementsByAccountAndIdentification(identification,accountNumber));
    }


}
