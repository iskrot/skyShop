package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;


    public BasketService(ProductBasket productBasket, StorageService storageService){
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void add(UUID id){
        if (!storageService.getProductById(id).isPresent()){
            throw new IllegalArgumentException();
        }
        else {
            productBasket.add(id);
        }
    }

    public UserBasket getUserBasket(){
        return new UserBasket(productBasket.getProductBasket().keySet().stream().map(i -> new BasketItem(storageService.getProductMap().get(i), productBasket.getProductBasket().get(i))).toList());
    }

}
