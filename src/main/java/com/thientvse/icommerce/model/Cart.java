package com.thientvse.icommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_attributte_id")
    private Integer productAttributteId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "price")
    private Integer price;

}
