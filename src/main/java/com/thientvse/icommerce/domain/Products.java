package com.thientvse.icommerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Products {
    @Id
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice")
    private Integer productPrice;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "createdAt")
    private java.sql.Timestamp createdAt;

    @Column(name = "updatedAt")
    private java.sql.Timestamp updatedAt;

    @Column(name = "brandId")
    private Integer brandId;

}
