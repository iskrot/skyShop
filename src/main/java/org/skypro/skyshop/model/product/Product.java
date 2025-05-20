package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable, Comparable {
    String type = "PRODUCT";
    String name;
    private final UUID id;

    public Product(String name, UUID id) throws Exception {
        if (name == null) {
            throw new IllegalArgumentException("У продукта должно быть имя.");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может состоять из пробелов.");
        }
        this.name = name;
        this.id = id;
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        return Searchable.super.compareTo(o);
    }

    @JsonIgnore
    public String getSearchTerm() {
        return name;
    }

    public String getStringRepresentation() {
        return name + "—" + type;
    }

    @JsonIgnore
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
