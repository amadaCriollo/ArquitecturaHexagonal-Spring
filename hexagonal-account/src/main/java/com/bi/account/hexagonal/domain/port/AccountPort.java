package com.bi.account.hexagonal.domain.port;

import com.bi.account.hexagonal.domain.model.Account;

import java.util.List;

public interface AccountPort {
    Account save(Account account);
    List<Account> getAllsAccounts();
    List<Account> getAccountsByCustomer(String identificationCustomer);
}
