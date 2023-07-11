package com.jxl.springboot.LibraryMS.repository;

import com.jxl.springboot.LibraryMS.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
