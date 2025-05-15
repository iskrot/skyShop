package org.skypro.skyshop.model.search;

import org.springframework.stereotype.Service;

import java.util.UUID;


public  class SearchResult {
    final UUID  id;
    final String name;
    final String contentType;

    SearchResult(UUID id, String name, String contentType){
        this.id = id;
        this.name = name;
        this.contentType = name;
    }

    public static SearchResult fromSearchable(Searchable searchable){
        return new SearchResult(searchable.getID(), searchable.getName(), searchable.getType());
    }
}
