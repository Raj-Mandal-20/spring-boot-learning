package com.springboot.project.cruddemo.dao;

import com.springboot.project.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
