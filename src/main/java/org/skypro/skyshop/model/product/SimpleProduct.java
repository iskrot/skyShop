package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price, UUID id) throws Exception {
        super(name, id);
        if (price <= 0){
            throw new IllegalArgumentException("Цена продукта должна быть больше нуля.");
        }
        this.price = price;

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return name+": "+getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
