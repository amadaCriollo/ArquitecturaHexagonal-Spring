package com.bi.account.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private List<Role> roles;
    private boolean expired = false;
    private boolean locked =false;
    private boolean disabled= false;
    private boolean credentialExpired= false;
}
