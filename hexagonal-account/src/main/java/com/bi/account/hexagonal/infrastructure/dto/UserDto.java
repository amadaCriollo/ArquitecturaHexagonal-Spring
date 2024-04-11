package com.bi.account.hexagonal.infrastructure.dto;

import java.util.List;

public record UserDto(
        String username,
        String password,
        List<String> roles) { }
