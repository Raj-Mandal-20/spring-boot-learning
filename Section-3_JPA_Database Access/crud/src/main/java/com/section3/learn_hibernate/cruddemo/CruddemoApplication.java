package com.section3.learn_hibernate.cruddemo;

import com.section3.learn_hibernate.cruddemo.dao.StudentDAO;
import com.section3.learn_hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner-> {
//            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
//            readStudentDetails(studentDAO);
//            sqlquery(studentDAO);
//              findAllStudents(studentDAO);


//              studentDAO.changeLastName(1000, "Charan");
//              studentDAO.changeLastName(1001, "Karan");
//              studentDAO.changeLastName(1002, "Naidu");

//            updateStudent(studentDAO, 1001);
//              deleteStudent(studentDAO, 1002);

//            deleteAllStudent(studentDAO);
        };

    }

    private void deleteAllStudent(StudentDAO studentDAO){
        studentDAO.deleteAll();
        System.out.println("All students are Deleted From DataBase! :(");
    }

    private void deleteStudent(StudentDAO studentDAO, int id){
        Student student = studentDAO.findById(id);
        studentDAO.delete(student);
        System.out.println("Student Deleted\n");
    }

    private void updateStudent(StudentDAO studentDAO, int id){
        Student student = studentDAO.findById(id);
        student.setFirstName("Dev");
        studentDAO.update(student);
        System.out.println("Student Updated!");

    }

    private void findAllStudents(StudentDAO studentDAO){
        List<Student> allStudents = studentDAO.findAll();
        for(int i=0; i<allStudents.size(); i++){
            System.out.println(allStudents.get(i));
        }
    }


    private void sqlquery(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("tilak");
        for(int i=0; i<students.size(); i++){
            System.out.println(students.get(i));
        }
    }

    private void readStudentDetails(StudentDAO studentDAO) {
        studentDAO.findById(1001);
    }


    private void createMultipleStudent(StudentDAO studentDAO) {
        // creating 3 student object
        System.out.println("Creating 3 Student objects");
        Student student1 = new Student("Ram", "Charan", "ram@wifi.com");
        Student student2 = new Student("Sam", "Basak", "Sam@wifi.com");
        Student student3 = new Student("Jodu", "Naidu", "Jodu@wifi.com");

        // save the objects
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("ID of Student1 " + student1.getId());
        System.out.println("ID of Student2 " + student2.getId());
        System.out.println("ID of Student3 " + student3.getId());


    }

    private void createStudent(StudentDAO studentDAO) {

        //  create the student object
        System.out.println("Creating Student Object\n");
        Student student = new Student("Raj","Mandal", "raj@gmail.com");

        // save the student object
        studentDAO.save(student);

        // display id of the saved object
        System.out.println("Saved student id " +student.getId());

    }
}
