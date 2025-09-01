package com.springboot.project.cruddemo.service;
import java.util.List;
import com.springboot.project.cruddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
//    Employee addEmployee(Employee theEmployee);
    void deleteById(int id);
    Employee save(Employee theEmployee);
}
