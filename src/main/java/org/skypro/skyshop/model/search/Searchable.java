package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String name = "";

    public String getName();

    public String getSearchTerm();

    public String getType();

    public String getStringRepresentation();

    public UUID getID();


    public default int compareTo(Object o) {

        Searchable searchable = (Searchable) o;

        if (name.length() == searchable.getName().length()) {
            return name.compareTo(searchable.getName());
        }
        return searchable.getName().length() - name.length();

    }
}
