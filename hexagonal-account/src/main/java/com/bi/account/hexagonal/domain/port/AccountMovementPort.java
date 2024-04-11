package com.bi.account.hexagonal.domain.port;

import com.bi.account.hexagonal.domain.model.AccountMovement;

public interface AccountMovementPort {
    AccountMovement save(AccountMovement accountMovement);
   // List<AccountMovement> getMovementByAccountAndCustomer(String accountNumber, String identification);
}
