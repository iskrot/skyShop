package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int price;
    private byte discounted;

    public DiscountedProduct(String name, int price, byte discounted, UUID id) throws Exception {
        super(name, id);
        if (price <= 0) {throw new IllegalArgumentException("Цена продукта должна быть больше нуля.");}

        if (0 > discounted | discounted > 100) {throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100.");}

        this.price = price;
        this.discounted = discounted;
    }

    @Override
    public int getPrice() {
        return (price * (100 - discounted)) / 100;
    }

    @Override
    public String toString() {
        return name + ": " + price + " (скидка: " + discounted + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
