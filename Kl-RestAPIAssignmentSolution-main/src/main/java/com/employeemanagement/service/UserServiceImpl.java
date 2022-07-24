package com.employeemanagement.service;

import com.employeemanagement.dao.UserRepository;
import com.employeemanagement.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public void deleteBYId(Long id){
         userRepository.deleteById(id);
    }


}
