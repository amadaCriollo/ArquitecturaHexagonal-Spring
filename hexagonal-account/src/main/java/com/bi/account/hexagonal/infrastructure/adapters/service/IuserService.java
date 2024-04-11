package com.bi.account.hexagonal.infrastructure.adapters.service;

import com.bi.account.hexagonal.infrastructure.entities.UserEntity;

public interface IuserService {
    public <Optional>UserEntity loadByUsername(String username);
}
