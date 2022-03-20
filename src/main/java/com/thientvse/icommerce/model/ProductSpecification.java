package com.thientvse.icommerce.model;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {
    public Specification<Product> getProduct(ProductRequest request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (request.getName() != null && !request.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")),
                        "%" + request.getName().toLowerCase() + "%"));
            }

            if (request.getCategoryId() != 0 ) {
                predicates.add(criteriaBuilder.equal(root.get("categoryId"), request.getCategoryId()));
            }

            if (request.getBrandId() != 0 ) {
                predicates.add(criteriaBuilder.equal(root.get("brandId"), request.getBrandId()));
            }
//            query.orderBy(criteriaBuilder.desc(root.get("productName")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
