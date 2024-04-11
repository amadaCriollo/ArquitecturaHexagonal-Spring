package com.bi.account.hexagonal.infrastructure.entities;

import com.bi.account.hexagonal.domain.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
@Builder
public class RoleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 20)
    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

  /*  @Override
    public String getAuthority() {
        return roleName.toString();
    }*/
}
