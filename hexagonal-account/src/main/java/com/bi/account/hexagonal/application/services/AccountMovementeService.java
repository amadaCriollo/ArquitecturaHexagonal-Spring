package com.bi.account.hexagonal.application.services;

import com.bi.account.hexagonal.domain.model.AccountMovement;
import com.bi.account.hexagonal.domain.port.AccountMovementPort;

public class AccountMovementeService implements AccountMovementPort {

    private final AccountMovementPort accountMovementPort;

    public AccountMovementeService(AccountMovementPort accountMovementPort) {
        this.accountMovementPort = accountMovementPort;
    }

    @Override
    public AccountMovement save(AccountMovement accountMovement) {
        return accountMovementPort.save(accountMovement);
    }

    //@Override
//    public List<AccountMovementDto> getMovementByAccountAndCustomer(String accountNumber, String identification) {
//        return accountMovementPort.getMovementByAccountAndCustomer(accountNumber, identification);
//    }
}
