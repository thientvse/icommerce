package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "product")
@SecondaryTables({
        @SecondaryTable(name = "category", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),
        @SecondaryTable(name = "brand", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),
        @SecondaryTable(name = "color", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")),

})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    /*@Column(name = "product_price")
    private Integer productPrice;*/

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "name", table = "category")
    private String categoryName;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "category_id")
//    private Category category;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "name", table = "brand")
    private String brandName;


    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "name", table = "color")
    private String colorName;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "brand_id")
//    private Brand brand;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    private Set<ShoppingCart> shoppingCarts = new HashSet<>();


    public Product() {
    }

    public Product(String name, String description, Integer quantity, Double unitPrice) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product(String name, String description, Integer categoryId, Integer brandId, Integer colorId, Integer quantity, Double unitPrice) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.colorId = colorId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
