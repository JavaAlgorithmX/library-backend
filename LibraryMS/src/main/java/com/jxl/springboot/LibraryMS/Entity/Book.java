package com.jxl.springboot.LibraryMS.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "title",unique = true,nullable = false)
    private String title;
    @Column(name = "publication_year")
    private int publicationYear;
    @Column(name = "isbn",unique = true)
    private String isbn;

    //Mappings
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("bookList")
    private List<Author> authorList = new ArrayList<>();

    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("bookList")
    private List<Genre> genreList = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookCopy> bookCopies;

    //Constructors
    public Book(){}

    public Book(String title, int publicationYear, String isbn) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    //Getters and Setters

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
