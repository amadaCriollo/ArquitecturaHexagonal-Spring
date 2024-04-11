package com.bi.account.hexagonal.infrastructure.controllers;

import com.bi.account.hexagonal.application.services.AccountService;
import com.bi.account.hexagonal.domain.model.Account;
import com.bi.account.hexagonal.infrastructure.exceptions.DuplicateEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws DuplicateEntityException {
        Account createdAccount = accountService.save(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAllsAccounts(){
        List<Account> accountList = accountService.getAllsAccounts();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<List<Account>> getAccountsByCustomer(@PathVariable String identification){
        List<Account> accountList = accountService.getAccountsByCustomer(identification);
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
}
