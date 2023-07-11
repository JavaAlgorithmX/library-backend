package com.jxl.springboot.LibraryMS.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;
    @Column(name = "publisher_name")
    private String name;
    @Column(name = "publisher_email")
    private String email;
    @Column(name = "publisher_website")
    private String website;
    @Column(name = "publisher_description")
    private String description;
    @Column(name = "date_added")
    private String dateAdded;

    //Mapping
    @OneToMany(mappedBy = "publisher")
    @JoinColumn(name = "publisher_id")
    private List<Book> bookList;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address")
    private Address address;

    //Constructor

    public Publisher() {
    }

    public Publisher(int id, String name, String email, String website, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.website = website;
        this.description = description;
    }


    //Getters and setters

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
