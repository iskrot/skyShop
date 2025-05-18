package org.skypro.skyshop.model.comparator;

import org.skypro.skyshop.model.search.SearchResult;

import java.util.Comparator;

public class MyComparator implements Comparator<SearchResult> {
    @Override
    public int compare(SearchResult s1, SearchResult s2) {
        if (s1.getName().length() == s2.getName().length()) {
            return s2.getName().compareTo(s1.getName());
        }
        return s1.getName().length()-s2.getName().length();
    }
}