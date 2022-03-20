package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
@SecondaryTables({
        @SecondaryTable(name = "category", pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id")),
        @SecondaryTable(name = "brand", pkJoinColumns = @PrimaryKeyJoinColumn(name = "brand_id"))
})

public class Product {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_des")
    private String productDes;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name", table = "category")
    private String categoryName;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name", table = "brand")
    private String brandName;


}
