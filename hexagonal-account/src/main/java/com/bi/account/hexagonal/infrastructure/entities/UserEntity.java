package com.bi.account.hexagonal.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
@Builder
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastName;
    @Column(length = 20)
    private String email;
    @Column(unique = true,length = 20)
    private String username;
    @Column(unique = true,length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns= @JoinColumn(name="role_id"))
    //uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rol_id"})})
    private Set<RoleEntity> roles;

    private boolean expired = false;
    private boolean locked =false;
    private boolean enabled= true;
    private boolean credentialExpired= false;

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialExpired;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }*/
}
