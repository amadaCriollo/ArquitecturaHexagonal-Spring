package com.bi.account.hexagonal.domain.model;

import com.bi.account.hexagonal.domain.enums.RoleName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Role {
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;
}
