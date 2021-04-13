package com.shop.onlineShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String hashedPassword;
    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "role")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

}
