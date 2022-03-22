package com.thientvse.icommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoppingCartDTO {
    private Long productId;
    private Integer stock;
    private String status;
}
