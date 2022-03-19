package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ProductRequest;

import java.util.List;

public interface ProductService {
     List<Product> getListProduct();
     List<Product> searchProduct(ProductRequest productRequest);

     List<Product> searchForProduct(String name, int categoryId, int brandId);
}
