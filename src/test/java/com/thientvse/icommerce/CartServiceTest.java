package com.thientvse.icommerce;


import com.thientvse.icommerce.model.Cart;
import com.thientvse.icommerce.repository.CartRepository;
import com.thientvse.icommerce.services.CarServiceImpl;
import com.thientvse.icommerce.services.CartService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class CartServiceTest {

//    @Mock
//    CartService cartService;



    @MockBean
    CartService carService;

    @MockBean
    CartRepository cartRepository;

    @Before
    public void setUp() {


    }

    @Test
    public void whenGetAll_shouldReturnList() {
        List<Cart> mockCarts = new ArrayList<>();
        // 1. create mock data
        for(int i = 0; i < 5; i++) {
            mockCarts.add(new Cart(1,2,3,4,5,6));
        }

        // 2. define behavior of Repository
        when(cartRepository.saveAll(mockCarts)).thenReturn(mockCarts);
//        when(cartRepository.findAll()).thenReturn(mockCarts);

        // 3. call service method
        List<Cart> actualCarts = carService.getListProductFromCart();

        // 4. assert the result
        assertEquals(actualCarts.size(),mockCarts.size());


        // 4.1 ensure repository is called
        verify(cartRepository).findAll();

    }

}
