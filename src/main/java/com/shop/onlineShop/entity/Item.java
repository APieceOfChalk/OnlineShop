package com.shop.onlineShop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "article_number")
    private Long articleNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "country")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "manufacturer")
    private Manufacturer manufacturer;
}
