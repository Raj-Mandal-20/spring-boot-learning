package com.springboot.project.cruddemo.service;


import com.springboot.project.cruddemo.dao.EmployeeRepository;
import com.springboot.project.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    private EmployeeDAO employeeDAO;

    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id){
        Optional<Employee> result  = employeeRepository.findById(id);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else throw new RuntimeException("Employee Not found!");

        return theEmployee;

    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = employeeRepository.save(theEmployee);
        return  employee;
    }


}
