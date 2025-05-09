package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService){
        this.storageService = storageService;
    }

    public TreeSet<Searchable> search(String searchString){
        TreeSet<Searchable> result = storageService.getcollectionSearchable().stream()
                .filter(i -> i.getSearchTerm().contains(searchString))
                .collect(Collectors.toCollection(() -> new TreeSet<>()));
        return result;
    }


}
