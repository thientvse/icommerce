package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.exceptions.ObjectNotFoundException;
import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.repository.ProductRepository;
import com.thientvse.icommerce.repository.specs.ProductSpecification;
import com.thientvse.icommerce.repository.specs.SearchCriteria;
import com.thientvse.icommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;


    @Autowired
    public ProductSpecification productSpecification;


    @Override
    public List<Product> searchProduct(List<SearchCriteria> searchCriteriaList) {
        
        
        List<Product> productList = new ArrayList<>();
        if (searchCriteriaList != null && searchCriteriaList.size() > 0){
            productSpecification = new ProductSpecification();
            searchCriteriaList.stream().forEach(searchCriteria -> productSpecification.add(searchCriteria));

            productList = productRepository.findAll(productSpecification);
        } else {
            productList = productRepository.findAll();
        }

        return productList;
    }

    @Override
    public Product getDetailProduct(long id) {
        return productRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
