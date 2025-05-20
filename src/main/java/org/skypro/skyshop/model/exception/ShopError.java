package org.skypro.skyshop.model.exception;


public final class ShopError {
    private final String cod;
    private final String messang;

    public String getCod() {
        return cod;
    }

    public String getMessang() {
        return messang;
    }

    public ShopError(String cod, String messang) {
        this.cod = cod;
        this.messang = messang;
    }


}
