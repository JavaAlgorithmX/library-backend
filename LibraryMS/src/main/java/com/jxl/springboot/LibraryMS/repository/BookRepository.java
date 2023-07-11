package com.jxl.springboot.LibraryMS.repository;

import com.jxl.springboot.LibraryMS.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
