package com.employeemanagement.service;

import com.employeemanagement.dao.RoleRepository;
import com.employeemanagement.dao.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl {
    @Autowired
    private RoleRepository roleRepository;
    public Role addRole(Role role){

        return roleRepository.save(role);
    }
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

}
