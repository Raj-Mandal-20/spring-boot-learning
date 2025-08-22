package com.section3.learn_hibernate.cruddemo.dao;

import com.section3.learn_hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manangement
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    // implement save method
    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id){
        Student student = entityManager.find(Student.class, id);
        System.out.println(student.toString());
        return student;
    }

    @Override
    public List<Student> findByLastName(String lastname){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:lname", Student.class);
        theQuery.setParameter("lname", lastname);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName", Student.class);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void changeLastName(int id, String lastName){
        Student student = entityManager.find(Student.class, id);
        student.setLastName(lastName);
    }

    @Transactional
    @Override
    public void update(Student student){
        entityManager.merge(student);
    }


    @Transactional
    @Override
    public void delete(Student student){
        Student managed = entityManager.merge(student);
        entityManager.remove(managed);
    }

    @Transactional
    @Override
    public void deleteAll(){
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }





}
