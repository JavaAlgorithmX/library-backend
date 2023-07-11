package com.jxl.springboot.LibraryMS;

import com.jxl.springboot.LibraryMS.Entity.Roles;
import com.jxl.springboot.LibraryMS.Entity.Users;
import com.jxl.springboot.LibraryMS.repository.AuthorRepository;
import com.jxl.springboot.LibraryMS.repository.BookRepository;
import com.jxl.springboot.LibraryMS.repository.UsersRepository;
import com.jxl.springboot.LibraryMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryMsApplication {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryMsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			m1();
		};
	}
	public void m1(){
//		Author author1 = new Author("Sakshee","sharma");
//		authorRepository.save(author1);
		//Author author = authorRepository.findById(1).get();

//		Book book1 = new Book();
//		book1.setTitle("Guide wire advance");
//		book1.getAuthorList().add(author);
////		author1.getBookList().add(book1);
//		bookRepository.save(book1);
//		author.getBookList().forEach(b-> System.out.println(b.getTitle()));
		//bookService.setNoOfCopiesToBook(2,5);


		//Creating users

//		Users users = new Users();
//		users.setEmail("madhav.madhukar@gmail.com");
//		users.setAddress("Pune");
//		users.setEnabled(true);
//		users.setUserName("madhav");
//		users.setLastName("Madhukar");
//		users.setFirstName("Madhav");
//		users.setPassword("Sakshee@34");
//		users.setMobileNumber("7909064575");
//		users.setPremium(true);
//
//		//creating role
//		Roles userRole = new Roles("USER");
//		userRole.getUsersList().add(users);
//		Roles librarianRole = new Roles("LIBRARIAN");
//		librarianRole.getUsersList().add(users);
//		Roles adminRole = new Roles("ADMIN");
//		adminRole.getUsersList().add(users);
//
//		//adding roles to roleList
//		List<Roles> rolesList = new ArrayList<>();
//		rolesList.add(userRole);
//		rolesList.add(librarianRole);
//		rolesList.add(adminRole);
//
//		//set role list of user
//		users.setRolesList(rolesList);
//
//		//Saving users
//		usersRepository.save(users);



	}

}
