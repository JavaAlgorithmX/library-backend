package com.jxl.springboot.LibraryMS.repository;

import com.jxl.springboot.LibraryMS.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
