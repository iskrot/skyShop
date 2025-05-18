package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new HashMap<>();



    public void add(UUID id){

        if (productBasket.containsKey(id)){
            productBasket.put(id, productBasket.get(id) + 1);
        }
        else {
            productBasket.put(id, 1);
        }
    }

    public Map<UUID, Integer> getProductBasket(){
        return Collections.unmodifiableMap(productBasket);
    }


}
