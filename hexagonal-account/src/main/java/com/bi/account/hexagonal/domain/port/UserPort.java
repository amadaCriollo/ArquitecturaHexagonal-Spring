package com.bi.account.hexagonal.domain.port;

import com.bi.account.hexagonal.domain.model.User;

public interface UserPort {
    User save(User user);
}
