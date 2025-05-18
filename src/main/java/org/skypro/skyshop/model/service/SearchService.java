package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.comparator.MyComparator;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import org.skypro.skyshop.model.search.SearchResult;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService){
        this.storageService = storageService;
    }

    public TreeSet<SearchResult> search(String searchString){
        TreeSet<SearchResult> result = storageService.getcollectionSearchable().stream()
                .filter(i -> i.getSearchTerm().contains(searchString))
                .map(i -> SearchResult.fromSearchable(i))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new MyComparator())));
        return result;

    }


}
