package com.jxl.springboot.LibraryMS.service;

import com.jxl.springboot.LibraryMS.Entity.Roles;
import com.jxl.springboot.LibraryMS.Entity.Users;
import com.jxl.springboot.LibraryMS.repository.RolesRepository;
import com.jxl.springboot.LibraryMS.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Transactional
    public void saveUser(Users users){
        List<Roles> rolesList = users.getRolesList();
        usersRepository.save(users);
        for(Roles roles :rolesList){
            roles.getUsersList().add(users);
        }
        rolesRepository.saveAll(rolesList);
    }
}
