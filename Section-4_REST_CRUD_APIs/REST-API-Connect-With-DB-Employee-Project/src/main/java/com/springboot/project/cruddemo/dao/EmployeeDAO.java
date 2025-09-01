package com.springboot.project.cruddemo.dao;
import java.util.List;
import com.springboot.project.cruddemo.entity.Employee;
import org.springframework.context.annotation.Bean;

public interface EmployeeDAO {
    List<Employee>  findAll();
    Employee findById(int id);
//    Employee addEmployee(Employee theEmployee);
    void deleteById(int id);
    Employee save(Employee theEmployee);
}
