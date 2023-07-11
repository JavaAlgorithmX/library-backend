package com.jxl.springboot.LibraryMS.repository;

import com.jxl.springboot.LibraryMS.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
