package com.bi.account.hexagonal.application.services;

import com.bi.account.hexagonal.domain.model.Account;
import com.bi.account.hexagonal.domain.port.AccountPort;

import java.util.List;

public class AccountService implements AccountPort {

    private AccountPort accountPort;

    public AccountService(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    @Override
    public Account save(Account account) {
        return accountPort.save(account);
    }

    @Override
    public List<Account> getAllsAccounts() {
        return accountPort.getAllsAccounts();
    }

    @Override
    public List<Account> getAccountsByCustomer(String identificationCustomer) {
        return accountPort.getAccountsByCustomer(identificationCustomer);
    }
}
