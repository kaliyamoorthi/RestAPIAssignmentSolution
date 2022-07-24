package com.employeemanagement.service;

import com.employeemanagement.dao.EmployeeRepository;
import com.employeemanagement.dao.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
        //employeeRepository.flush();
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteById(long id){
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getEmployeeByID(long id){
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
//    public void updateById(Long Id){
//        employeeRepository.
//    }

    public List<Employee> getEmployeesCustomSortedByFirstName(Sort.Direction direction) {
         return employeeRepository.findAll(Sort.by(direction, "firstName"));
    }

    public List<Employee> searchEmployeeByFirstName(String fName){
        Employee demoEmployee = new Employee();
        demoEmployee.setFirstName(fName);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("id", "lastName","email");
        Example<Employee> example = Example.of(demoEmployee, exampleMatcher);
//        Example<Employee> example = Example.of(demoEmployee);

        return employeeRepository.findAll(example);

    }

}
