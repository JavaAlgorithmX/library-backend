package com.jxl.springboot.LibraryMS.Entity;

import jakarta.persistence.*;

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
    @ManyToMany
    private List<Book> bookList;


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

    //To String

    @Override
    public String toString() {
        return "Genre{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
