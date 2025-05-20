package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;


@RestController
public class ShopController {
    StorageService storageService = new StorageService(new HashMap<>(), new HashMap<>());
    SearchService searchService = new SearchService(storageService);
    BasketService basketService = new BasketService(new ProductBasket(),storageService);

    public ShopController() throws Exception {
    }


    @GetMapping("/basket/{id}")
    public ResponseEntity addProduct(@PathVariable("id") UUID id){
        basketService.add(id);
        return ResponseEntity.ok().body("Продукт успешно добавлен");
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket(){
        System.out.println(basketService.getUserBasket());
        return basketService.getUserBasket();
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts(){
        return storageService.getProductMap().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles(){
        return storageService.getArticleMap().values();
    }

    @GetMapping("/search")
    public Collection<SearchResult> search(
            @RequestParam("pattern") String pattern
    ){
        return searchService.search(pattern);
    }


}
