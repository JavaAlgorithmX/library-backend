package com.jxl.springboot.LibraryMS.rest;

import com.jxl.springboot.LibraryMS.Entity.Book;
import com.jxl.springboot.LibraryMS.Entity.Users;
import com.jxl.springboot.LibraryMS.repository.UsersRepository;
import com.jxl.springboot.LibraryMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class UsersRestController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody Users users) {
        try {
            // Invoke the necessary service method to save the book with author
            userService.saveUser(users);
            //System.out.println("user created");
            if(users.getId()!=0){
                return ResponseEntity.ok("User updated successfully.");
            }
            return ResponseEntity.ok("User created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create book.");
        }
    }


}
