package com.jxl.springboot.LibraryMS.repository;

import com.jxl.springboot.LibraryMS.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
