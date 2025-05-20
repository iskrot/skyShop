package org.skypro.skyshop.model.service;

import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exception.NoSuchProductException;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    ProductBasket productBasket;
    @Mock
    StorageService storageService;
    @InjectMocks
    BasketService basketService;

    @Test
    public void productAdditionErrorTest() {
        Exception exception = null;
        Exception exception1 = new IllegalArgumentException();
        try {
            basketService.add(UUID.randomUUID());
        } catch (Exception e) {
            exception = e;
        }
        Assertions.assertEquals(exception.getMessage(), exception1.getMessage());
    }

    @Test
    public void productAddingTest() throws Exception {
        Product product = new SimpleProduct("name", 100, UUID.randomUUID());
        Optional<Product> optional = Optional.of(new SimpleProduct("s", 40, UUID.randomUUID()));
        Mockito.when(storageService.getProductById(Mockito.any())).thenReturn(optional);
        basketService.add(product.getID());
        Mockito.verify(productBasket).add(product.getID());

    }

    @Test
    public void getUserBasketVoidTest() {
        UserBasket userBasket = basketService.getUserBasket();
        Assertions.assertEquals(userBasket.getList(), (List) new ArrayList<>());
    }

    @Test
    public void getUserBasketTest() throws Exception {
        Product product = new SimpleProduct("name", 100, UUID.randomUUID());
        Map<UUID, Integer> map = new HashMap<>();
        Map<UUID, Product> mapProduct = new HashMap<>();
        Optional<Product> optional = Optional.of(product);

        map.put(product.getID(),1);
        mapProduct.put(product.getID(), product);
        List list = new ArrayList();
        list.add(product);


        Mockito.when(storageService.getProductById(product.getID())).thenReturn(optional);


        Mockito.when(productBasket.getProductBasket()).thenReturn(map);
        Mockito.when(storageService.getProductMap()).thenReturn(mapProduct);

        basketService.add(product.getID());
        UserBasket userBasket = basketService.getUserBasket();

        Assertions.assertEquals(userBasket.getList().stream().map(i -> i.getProduct()).toList(), list);
    }
}