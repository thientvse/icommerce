package com.thientvse.icommerce.services;

import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.model.ProductRequest;
import com.thientvse.icommerce.model.ProductSpecification;
import com.thientvse.icommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    public ProductRepository productRepository;


    @Autowired
    public ProductSpecification productSpecification;


    @Override
    public List<Product> searchProduct(ProductRequest productRequest) {

        if (productRequest.getName() != null ){
            return productRepository.findAll(productSpecification.getProduct(productRequest));
        }

        return productRepository.findAll();
    }

    @Override
    public Product getProductDetail(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> createProduct(List<Product> productRequestList) {
        return productRepository.saveAll(productRequestList);
    }


//    @Override
//    public List<Product> searchForProduct(String name, int categoryId, int brandId) {
//        Specification<Product> specification = (root, query, cb) -> {
//            final Path<String> path = root.get("productName");
//
//            return cb.like(path, "%"+name+"%");
//        };
//
//        Specification<Product> specCategoryId = (root, query, cb) -> {
//            final Path<String> path = root.get("categoryId");
//
//            return cb.equal(path, categoryId);
//        };
//
//        Specification<Product> specBrandId = (root, query, cb) -> {
//            final Path<String> path = root.get("brandId");
//
//            return cb.equal(path, brandId);
//        };
//
//        return productRepository.findAll(specification.and(specCategoryId).and(specBrandId));
//    }
}
