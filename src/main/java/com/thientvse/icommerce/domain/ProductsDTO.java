package com.thientvse.icommerce.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer productPrice;
    private Integer categoryId;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private Integer brandId;


}
