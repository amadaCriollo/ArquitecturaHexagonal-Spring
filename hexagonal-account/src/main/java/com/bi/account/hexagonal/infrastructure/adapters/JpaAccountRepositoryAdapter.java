package com.bi.account.hexagonal.infrastructure.adapters;

import com.bi.account.hexagonal.domain.model.Account;
import com.bi.account.hexagonal.domain.port.AccountPort;
import com.bi.account.hexagonal.infrastructure.entities.AccountEntity;
import com.bi.account.hexagonal.infrastructure.exceptions.DuplicateEntityException;
import com.bi.account.hexagonal.infrastructure.mapper.AccountMapper;
import com.bi.account.hexagonal.infrastructure.repositories.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JpaAccountRepositoryAdapter implements AccountPort {

    private final JpaAccountRepository jpaAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter;

    @Override
    public Account save(Account account) throws  DuplicateEntityException {
        System.out.println("customer-->" + account.getCustomer());
        System.out.println("customer-->" + account.getTotalValue());
        if(jpaAccountRepository.existsByAccountNumber(account.getAccountNumber()) ){
            throw  new DuplicateEntityException("Esta cuenta ya existe");
        }
        account.setCustomer(jpaCustomerRepositoryAdapter.save(account.getCustomer()));
        AccountEntity savedAccountEntity = jpaAccountRepository.save(accountMapper.toEntity(account));
        log.info("value--> " + savedAccountEntity.getTotalValue());
        return accountMapper.toDomain(savedAccountEntity);
    }

    @Override
    public List<Account> getAllsAccounts() {
        return  accountMapper.toAccounts(jpaAccountRepository.findAll());
    }

    @Override
    public List<Account> getAccountsByCustomer(String identificationCustomer) {
        return accountMapper.toAccounts(jpaAccountRepository.getAccountsByCustomer(identificationCustomer));
    }

}
