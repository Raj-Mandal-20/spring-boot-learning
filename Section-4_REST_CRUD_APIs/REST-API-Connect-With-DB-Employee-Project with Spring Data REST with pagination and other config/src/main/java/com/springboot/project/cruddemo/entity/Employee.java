package com.springboot.project.cruddemo.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "employee")
public class Employee {
    // define field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    // define constructors

    public Employee(){

    }

    public Employee(int id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getter/ setter

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    //  define toString
    public String getInfo(){
        return "Id = "+this.id + ", First Name = "+this.firstName+", Last Name = "+this.lastName+", Email = "+this.email +" :)";
    }

}
