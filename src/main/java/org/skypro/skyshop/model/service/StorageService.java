package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.exception.NoSuchProductException;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> productMap;
    private final Map<UUID, Article> articleMap;

    public StorageService(Map<UUID, Product> productMap, Map<UUID, Article> articleMap) throws Exception {
        this.productMap = productMap;
        this.articleMap = articleMap;
        test();
    }

    public void test() throws Exception {
        Product[] listOfProducts = {new SimpleProduct("морковь", 40, UUID.randomUUID()), new DiscountedProduct("огурец", 50, (byte) 20, UUID.randomUUID()), new FixPriceProduct("молоко", UUID.randomUUID())};

        Article bigCup = new Article("Пол-литровая кружка", "Она настолько большая, что вы в ней утоните!!", UUID.randomUUID());
        Article bucket = new Article("Ведро с болтами", "Это... реально ведро с болтами. А вы чего-то другого ожидали?", UUID.randomUUID());
        Article slippers = new Article("Эко тапки", "Сделано из бутылок. Спасайте природу вместе с нами!!", UUID.randomUUID());
        Article carott = new Article("морковъ", "куда тверже обычной моркови", UUID.randomUUID());


        for (byte i = 0; i < 3; i++){
            Product product = listOfProducts[(byte) (i)];
            productMap.put(product.getID(), product);
        }

        articleMap.put(bigCup.getID(),bigCup);
        articleMap.put(bucket.getID(),bucket);
        articleMap.put(slippers.getID(),slippers);
        articleMap.put(carott.getID(),carott);

    }

    public Collection<Searchable> getcollectionSearchable(){
        Collection<Searchable> collection = new ArrayList<>(productMap.values().stream().toList().stream().map(i -> (Searchable) i).toList());
        collection.addAll(articleMap.values().stream().map(i -> (Searchable) i).toList());
        return collection;
    }

    public Map<UUID, Article> getArticleMap() {
        return articleMap;
    }

    public Map<UUID, Product> getProductMap() {
        return productMap;
    }

    public Optional<Product> getProductById(UUID id) {
        if (!productMap.containsKey(id)){
            throw new NoSuchProductException();
        }
        return Optional.ofNullable(productMap.get(id));
    }
}
