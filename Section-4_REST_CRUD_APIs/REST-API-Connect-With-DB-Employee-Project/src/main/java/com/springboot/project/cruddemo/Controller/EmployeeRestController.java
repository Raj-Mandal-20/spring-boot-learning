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


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
         theEmployee.setId(0);
         System.out.println(theEmployee.getId());
         System.out.println(theEmployee.getFirstName());
         System.out.println(theEmployee.getLastName());
         System.out.println(theEmployee.getEmail());

         Employee employee = employeeService.save(theEmployee);
         return employee;
//        employeeService.addEmployee(theEmployee);
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

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        // this is implementation when id is provided explicitly in the request body

        Employee employee = employeeService.save(theEmployee);
        return employee;

        // if id is not provided in request body then
        // implementation...

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){

        if(employeeService.findById(id) == null){
            throw new EmployeeException("No Employee found With this id"+ id);
        }

       employeeService.deleteById(id);
        throw new EmployeeException("Employee Deleted!");
    }

}
