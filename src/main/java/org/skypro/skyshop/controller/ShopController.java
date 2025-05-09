package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class ShopController {
    StorageService storageService = new StorageService(new HashMap<>(), new HashMap<>());
    SearchService searchService = new SearchService(storageService);

    public ShopController() throws Exception {
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
