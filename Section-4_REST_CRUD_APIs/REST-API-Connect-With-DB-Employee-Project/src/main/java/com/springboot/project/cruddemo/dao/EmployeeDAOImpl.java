package com.springboot.project.cruddemo.dao;


import com.springboot.project.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id){
       Employee employee = entityManager.find(Employee.class, id);
       return employee;
    }
    @Override
    public Employee save(Employee theEmployee){
        Employee employee = entityManager.merge(theEmployee);
        return employee;
    }

//    @Override
//    public Employee addEmployee(Employee theEmployee){
//        theEmployee.setId(0);
//        Employee employee = entityManager.merge(theEmployee);
//        return  employee;
//    }


    @Override
    public void deleteById(int id){
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }


}
