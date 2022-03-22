package com.thientvse.icommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@SecondaryTables({
        @SecondaryTable(name = "category", pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id")),
        @SecondaryTable(name = "brand", pkJoinColumns = @PrimaryKeyJoinColumn(name = "brand_id")),
        @SecondaryTable(name = "color", pkJoinColumns = @PrimaryKeyJoinColumn(name = "color_id")),

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

    @Column(name = "color_id")
    private Integer colorId;

    @Column(name = "color_name", table = "color")
    private String colorName;

    /*@OneToMany(targetEntity = Color.class, mappedBy = "color_id", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Color> colors;*/

    /*@Column(name = "attribute_value_id")
    private Integer attributeValueId;

    @Column(name = "value", table = "attribute_value")
    private String value;*/

//    @OneToMany(targetEntity = AttributeValue.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
//    private List<AttributeValue> attributeValues;

}
