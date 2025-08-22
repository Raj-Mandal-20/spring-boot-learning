package com.rest.application.Rest.Aplications.Learning.Entity;


public class Student {
    private int studentId;
    private String firstName;
    private String lastName;

    public Student(){

    }
    public Student(int studentId,String firstName, String lastName){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public void setFirstName(String firstName){
//        this.firstName = firstName;
//    }
//    public void setLastName(String lastName){
//        this.lastName = lastName;
//    }
    public void setStudentId(int studentId) {
          this.studentId = studentId;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getFullName(){
        return this.firstName + " "+ this.lastName;
    }
    public int getStudentId(){
        return this.studentId;
    }


}
