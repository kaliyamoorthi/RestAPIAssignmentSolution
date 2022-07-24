package com.employeemanagement.controller;


import com.employeemanagement.dao.entity.Role;

import com.employeemanagement.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Username:"+authentication.getName());
//        System.out.println("Principal:"+authentication.getAuthorities());
        return roleService.getAllRoles();
    }

    @PostMapping(value = "/add",consumes = {"application/json"})
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
}
