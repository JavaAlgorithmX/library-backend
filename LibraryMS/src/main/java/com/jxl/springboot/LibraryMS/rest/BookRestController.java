package com.jxl.springboot.LibraryMS.rest;

import com.jxl.springboot.LibraryMS.BookCopiesDTO;
import com.jxl.springboot.LibraryMS.Entity.Book;
import com.jxl.springboot.LibraryMS.repository.AuthorRepository;
import com.jxl.springboot.LibraryMS.repository.BookRepository;
import com.jxl.springboot.LibraryMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookCopiesDTO bookCopiesDTO;

    @PostMapping("/books")
    public ResponseEntity<String> createBookWithAuthor(@RequestBody Book book) {
        try {
            // Invoke the necessary service method to save the book with author
            bookService.saveBookWithAuthor(book);
            return ResponseEntity.ok("Book created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create book.");
        }
    }

    @PostMapping("/books/withCopy")
    public ResponseEntity<String> createBookWithCopy(@RequestBody BookCopiesDTO bookCopiesDTO) {
        try {
            System.out.println(bookCopiesDTO.getBook());
            System.out.println(bookCopiesDTO.getBook().getAuthorList());
            System.out.println(bookCopiesDTO.getNoOfCopies());
            // Invoke the necessary service method to save the book with author
            bookService.saveBookWithAuthorAndCopies(bookCopiesDTO.getBook(),bookCopiesDTO.getNoOfCopies());
            return ResponseEntity.ok("Book created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create book.");
        }
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBookWithAuthor( ) {
        List<Book> bookList;
            // Invoke the necessary service method to save the book with author
            bookList = bookService.getBookWithAuthor();
            return ResponseEntity.of(Optional.ofNullable(bookList));
    }

    @GetMapping("/books/author-{authorId}")
    public ResponseEntity<List<String>> getBookWithAuthor(@PathVariable Integer authorId) {
        List<String> bookList = bookService.getBookByAuthor(authorId);
        return ResponseEntity.of(Optional.ofNullable(bookList));
    }


}
