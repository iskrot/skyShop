package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.exception.NoSuchProductException;
import org.skypro.skyshop.model.exception.ShopError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchFieldHandler(NoSuchProductException e){
        ShopError shopError = new ShopError("NO_SUCH_PRODUCT_WITH_THIS_ID", "Продукт с таким id не найден");
        return new ResponseEntity<ShopError>(shopError, HttpStatusCode.valueOf(404));
    }





}
