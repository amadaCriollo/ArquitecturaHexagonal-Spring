package com.bi.account.hexagonal.infrastructure.controllers;

import com.bi.account.hexagonal.infrastructure.adapters.JpaUserRepositoryAdapter;
import com.bi.account.hexagonal.infrastructure.dto.MessageDto;
import com.bi.account.hexagonal.infrastructure.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final JpaUserRepositoryAdapter userService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }
}
