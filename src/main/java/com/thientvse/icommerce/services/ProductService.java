package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.repository.specs.SearchCriteria;

import java.util.List;

public interface ProductService {

     List<Product> searchProduct(List<SearchCriteria> searchCriteriaList);

     Product getDetailProduct(long id);

     List<Product> findAll();

     Product addProduct(Product product);
}
