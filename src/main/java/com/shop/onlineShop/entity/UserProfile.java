package com.shop.onlineShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    @Column(name = "user_id")
    private Long userProfileId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;
    @Column(name = "housing")
    private String housing;
    @Column(name = "flat")
    private String flat;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users users;




}
