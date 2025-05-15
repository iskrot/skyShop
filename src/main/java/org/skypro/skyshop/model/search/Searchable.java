package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String name = "";

    public String getName();

    public String getSearchTerm();

    public String getType();

    public String getStringRepresentation();

    public UUID getID();
}
