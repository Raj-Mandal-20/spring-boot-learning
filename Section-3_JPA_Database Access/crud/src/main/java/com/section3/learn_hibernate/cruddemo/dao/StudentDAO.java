package com.section3.learn_hibernate.cruddemo.dao;

import com.section3.learn_hibernate.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findByLastName(String lastname);
    List<Student> findAll();
    void changeLastName(int id, String lastName);
    void update(Student student);
    void delete(Student student);
    void deleteAll();

}
