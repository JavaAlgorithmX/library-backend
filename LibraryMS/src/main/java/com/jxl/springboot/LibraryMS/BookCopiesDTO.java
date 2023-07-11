package com.jxl.springboot.LibraryMS;

import com.jxl.springboot.LibraryMS.Entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BookCopiesDTO {

    private Book book;
    private int noOfCopies;

    public BookCopiesDTO(Book book, int noOfCopies) {
        this.book = book;
        this.noOfCopies = noOfCopies;
    }

    public BookCopiesDTO() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
}
