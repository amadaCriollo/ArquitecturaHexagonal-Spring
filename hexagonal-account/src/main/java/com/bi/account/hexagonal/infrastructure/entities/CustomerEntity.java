package com.bi.account.hexagonal.infrastructure.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@Builder
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) @Getter
    private Long id;
    @Column(unique = true,length = 13)
    private String identification;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastName;

}
