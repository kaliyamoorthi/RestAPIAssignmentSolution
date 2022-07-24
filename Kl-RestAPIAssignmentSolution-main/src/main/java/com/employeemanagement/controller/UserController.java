package com.employeemanagement.controller;

import com.employeemanagement.dao.entity.User;
import com.employeemanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value="/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
       userService.deleteBYId(id);
    }

}
