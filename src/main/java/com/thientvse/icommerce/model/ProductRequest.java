package com.thientvse.icommerce.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    String name;
    int categoryId;
    int brandId;
    int color;


}
