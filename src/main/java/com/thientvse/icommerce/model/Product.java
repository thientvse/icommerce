package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String productDes;

    @Column(name = "unit_price")
    private Integer productPrice;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "brand_id")
    private Integer brandId;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();*/


}
