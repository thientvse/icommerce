package com.thientvse.icommerce;


import com.thientvse.icommerce.model.Product;
import com.thientvse.icommerce.repository.ProductRepository;
import com.thientvse.icommerce.services.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @MockBean
    ProductRepository productRepository;

    @Mock
    ProductServiceImpl productService;


    @Test
    public void whenGetAll_shouldReturnList(){
        // 1. create mock data
        List<Product> mockProducts = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockProducts.add(new Product("Product"+i,"Des "+i, 10, 500.0));
        }

        // 2. define behavior of Repository
        when(productRepository.findAll()).thenReturn(mockProducts);

        // 3. call service method
        List<Product> actualProducts = productService.findAll();

        // 4. assert the result
        assertEquals(actualProducts.size(),mockProducts.size());

        // 4.1 ensure repository is called
        verify(productRepository).findAll();

        /*int a = 10;
        assertTrue(a>0);*/
    }

    @Test
    public void GivenGetAllProduct_shouldReruenListOfAllProducts(){
        Product product1 = new Product("Product 1","Des 1",1,1,1, 10, 500.0);
        Product product2 = new Product("Product 2","Des 2",1,1,1, 30, 800.0);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = (List<Product>) productRepository.findAll();
        assertEquals("Product 1", productList.get(0).getName());
    }

}
