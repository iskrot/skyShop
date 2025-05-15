package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private final Product product;
    private final int total;

    public BasketItem(Product product, int total){
        this.total = total;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getTotal() {
        return total;
    }
}
