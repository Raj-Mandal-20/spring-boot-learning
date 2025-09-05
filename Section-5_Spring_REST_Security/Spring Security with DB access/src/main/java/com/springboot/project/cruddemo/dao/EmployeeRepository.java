package com.springboot.project.cruddemo.dao;

import com.springboot.project.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "members") // change api endpoint name
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
