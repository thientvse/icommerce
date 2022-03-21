package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ProductRequest;

import java.util.List;

public interface ProductService {
     List<Product> searchProduct(ProductRequest productRequest);

     Product getProductDetail(long id);

     List<Product> createProduct(List<Product> productRequestList);

}
