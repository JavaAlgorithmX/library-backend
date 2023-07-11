package com.jxl.springboot.LibraryMS.service;

import com.jxl.springboot.LibraryMS.Entity.Author;
import com.jxl.springboot.LibraryMS.Entity.Book;
import com.jxl.springboot.LibraryMS.Entity.BookCopy;
import com.jxl.springboot.LibraryMS.repository.AuthorRepository;
import com.jxl.springboot.LibraryMS.repository.BookCopyRepository;
import com.jxl.springboot.LibraryMS.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Transactional
    public Book saveBookWithAuthor(Book book) {
        List<Author> authors = book.getAuthorList();
        authorRepository.saveAll(authors);
        // Save the book entity
        Book dbBook = bookRepository.save(book);
        // Set the book in each author entity
        for (Author author : authors) {
            author.getBookList().add(book);
        }
        // Save the updated author entities
        authorRepository.saveAll(authors);
        return dbBook;
    }
    @Transactional
    public void setNoOfCopiesToBook(Book book, int noOfCopies){
        for(int i=1;i<=noOfCopies;i++){
            BookCopy bc = new BookCopy();
            bc.setBook(book);
            bc.setAvailable(true);
            bookCopyRepository.save(bc);
        }
        System.out.println(noOfCopies +" copies of the book "+book.getTitle()+" has been successfully added to DB");
    }

    public void saveBookWithAuthorAndCopies(Book book,int noOfCopies) {
        /*
            two parameters

         */
       Book savedBook = saveBookWithAuthor(book);
       setNoOfCopiesToBook(savedBook,noOfCopies);
    }


    public List<Book> getBookWithAuthor() {
        return bookRepository.findAll();
    }
    public List<String> getBookByAuthor(Integer id) {
        List<Book> bookList = authorRepository.findById(id).get().getBookList();
        List<String> bookTitleList = new ArrayList<>();
        for(Book b:bookList){
            bookTitleList.add(b.getTitle());
        }
        return bookTitleList;
    }
}
