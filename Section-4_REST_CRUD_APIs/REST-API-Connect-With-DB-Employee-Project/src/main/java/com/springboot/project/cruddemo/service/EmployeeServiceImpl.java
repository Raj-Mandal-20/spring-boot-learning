package com.springboot.project.cruddemo.service;


import com.springboot.project.cruddemo.dao.EmployeeDAO;
import com.springboot.project.cruddemo.dao.EmployeeDAOImpl;
import com.springboot.project.cruddemo.entity.Employee;
import com.springboot.project.cruddemo.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id){
        return employeeDAO.findById(id);
    }

//    @Override
//    @Transactional
//    public Employee addEmployee(Employee theEmployee){
//        return employeeDAO.addEmployee(theEmployee);
//    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        Employee employee = employeeDAO.save(theEmployee);
        return  employee;
    }


}
