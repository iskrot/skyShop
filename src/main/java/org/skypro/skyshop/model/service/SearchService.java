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

    public static class MyComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s1.getSearchTerm().length() == s2.getSearchTerm().length()) {
                return s2.getSearchTerm().compareTo(s1.getSearchTerm());
            }
            return s1.getSearchTerm().length()-s2.getSearchTerm().length();
        }
    }
}
