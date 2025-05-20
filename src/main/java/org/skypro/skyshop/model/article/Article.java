package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable, Comparable {
    String text;
    String type = "ARTICLE";
    String name;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    @JsonIgnore
    public String getType() {
        return "Article";
    }

    @Override
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }


    public String getStringRepresentation() {
        return name + "—" + type;
    }

    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        return Searchable.super.compareTo(o);
    }

    @Override
    public String toString() {
        return
                name + '\n' +
                        text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }


}
