package com.jxl.springboot.LibraryMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int Id;

    @Column(name = "genre_name")
    private String name;

    //Mappings
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonIgnoreProperties("genreList")
    private List<Book> books = new ArrayList<>();


//Constructor
    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    //Getters and Setters

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    //To String

    @Override
    public String toString() {
        return "Genre{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
