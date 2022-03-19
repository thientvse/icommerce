package com.thientvse.icommerce;

import com.thientvse.icommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IcommerceApplication implements CommandLineRunner {

    @Autowired
    public ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(IcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nfindAll()");
        productRepository.findAll().forEach(x -> System.out.println(x));
        System.out.println("\nDone");
    }
}
