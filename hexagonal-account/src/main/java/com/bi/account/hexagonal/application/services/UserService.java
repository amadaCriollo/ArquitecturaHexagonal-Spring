package com.bi.account.hexagonal.application.services;

import com.bi.account.hexagonal.domain.model.User;
import com.bi.account.hexagonal.domain.port.UserPort;

public class UserService implements UserPort {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public User save(User user) {
        return userPort.save(user);
    }
}
