package com.shop.onlineShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ItemInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemInfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "parent_item")
    private Item parentItem;

    @Column(name = "colour")
    private String colour;
    @Column(name = "price")
    private Double price;
    @Column(name = "amount")
    private Integer amount;


}
