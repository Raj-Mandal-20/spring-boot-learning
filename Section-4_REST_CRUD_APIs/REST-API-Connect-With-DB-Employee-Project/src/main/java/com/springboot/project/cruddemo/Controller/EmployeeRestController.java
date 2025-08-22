package com.springboot.project.cruddemo.Controller;

import com.springboot.project.cruddemo.dao.EmployeeDAO;
import com.springboot.project.cruddemo.dao.EmployeeDAOImpl;
import com.springboot.project.cruddemo.entity.Employee;
import com.springboot.project.cruddemo.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {



//    private EmployeeDAO employeeDAO;
//
//    public EmployeeRestController(EmployeeDAO employeeDAO){
//        this.employeeDAO = employeeDAO;
//    }
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        if(this.employeeService.findById(id) == null) {
            throw new EmployeeException("Employee with id = "+id+ " not found :(");
        }
        return this.employeeService.findById(id);
    }


}
