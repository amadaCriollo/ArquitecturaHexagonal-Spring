package com.bi.account.hexagonal.infrastructure.controllers;

import com.bi.account.hexagonal.application.services.AccountMovementeService;
import com.bi.account.hexagonal.domain.model.AccountMovement;
import com.bi.account.hexagonal.infrastructure.adapters.service.ListAccountMovementService;
import com.bi.account.hexagonal.infrastructure.dto.AccountDto;
import com.bi.account.hexagonal.infrastructure.dto.AccountMovementDto;
import com.bi.account.hexagonal.infrastructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class AccountMovementController {

    private final AccountMovementeService accountMovementService;
    @Autowired
    private ListAccountMovementService listAccountMovementService;

    public AccountMovementController(AccountMovementeService accountMovementService) {
        this.accountMovementService = accountMovementService;
    }

    @PostMapping
    public ResponseEntity<AccountMovement> createMovement(@RequestBody AccountMovement movement) throws NotFoundException {
        AccountMovement createdMovement = accountMovementService.save(movement);
        return new ResponseEntity<>(createdMovement, HttpStatus.CREATED);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<AccountMovementDto>> getMovementsByAccountAndCustomer(@RequestBody AccountDto accountDto){
        List<AccountMovementDto> movementList = listAccountMovementService.getMovementByAccountAndCustomer(accountDto.getIdentification(),accountDto.getAccountNumber());
        return new ResponseEntity<>(movementList, HttpStatus.OK);
    }
}
