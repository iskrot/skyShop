package org.skypro.skyshop.model.basket;

import java.util.List;

public final class UserBasket {
    private final List<BasketItem> list;
    private final int total;

    public UserBasket(List<BasketItem> list){
        this.list = list;
        this.total = list.stream().mapToInt(i -> i.getProduct().getPrice()*i.getTotal()).sum();
    }

    public List<BasketItem> getList() {
        return list;
    }

    public int getTotal() {
        return total;
    }
}
