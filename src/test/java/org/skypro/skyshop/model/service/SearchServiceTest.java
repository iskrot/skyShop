package org.skypro.skyshop.model.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.comparator.MyComparator;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    StorageService storageService;
    @InjectMocks
    SearchService searchService;




    @Test
    public void searchThrough_an_emptyListTest() throws Exception {
        TreeSet<SearchResult> resul = searchService.search("s");
        TreeSet<SearchResult> treeSet = new TreeSet<SearchResult>(new MyComparator());
        Assertions.assertEquals(resul, treeSet);
    }
    @Test
    public void productNotFoundTest() throws Exception {
        List<Searchable> list = new ArrayList();
        Product product = new SimpleProduct("g", 40, UUID.randomUUID());
        list.add(product);
        Mockito.when(storageService.getcollectionSearchable()).thenReturn(list);
        TreeSet<SearchResult> resul = searchService.search("s");
        Assertions.assertEquals(resul, new TreeSet<>());
    }
    @Test
    public void productFoundTest() throws Exception {
        List<Searchable> list = new ArrayList();
        Product product = new SimpleProduct("s", 40, UUID.randomUUID());
        list.add(product);
        Mockito.when(storageService.getcollectionSearchable()).thenReturn(list);
        TreeSet<SearchResult> resul = searchService.search("s");
        TreeSet<SearchResult> treeSet = new TreeSet<SearchResult>(new MyComparator());
        treeSet.add(SearchResult.fromSearchable(product));
        Assertions.assertEquals(resul, treeSet);
    }
}
