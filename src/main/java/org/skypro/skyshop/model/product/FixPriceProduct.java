package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private final int price = 100;

    public FixPriceProduct(String name, UUID id) throws Exception {
        super(name, id);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
