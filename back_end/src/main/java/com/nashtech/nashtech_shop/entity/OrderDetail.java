package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private int quantity ;

    private double price ;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product ;


}
