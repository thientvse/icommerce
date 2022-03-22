package com.thientvse.icommerce.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {

    String name;
    int categoryId;
    int brandId;
    int attributeValueId;
    int colorId;
}


