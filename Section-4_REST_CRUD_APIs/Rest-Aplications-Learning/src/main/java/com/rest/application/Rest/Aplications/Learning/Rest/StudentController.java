package com.rest.application.Rest.Aplications.Learning.Rest;


import com.rest.application.Rest.Aplications.Learning.Entity.CustomException;
import com.rest.application.Rest.Aplications.Learning.Entity.Student;
import com.rest.application.Rest.Aplications.Learning.Entity.StudentNotFoundResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        theStudents.add(new Student(1,"Ram", "Charan"));
        theStudents.add(new Student(2,"Devdut", "Naiya"));
        theStudents.add(new Student(3,"Nayan", "Poria"));
    }

    @GetMapping("/all")
    public List<Student> allStudents(){
        return this.theStudents;
    }

    @GetMapping("/{idx}")
    public Student studentInfo(@PathVariable int idx){
//        String str = id;
//        for(int i=0; i<str.length(); i++){
//            if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
//                continue;
//            }
//            else {
//                throw new CustomException("Bad Request", 400);
//            }
//        }
//        int idx = Integer.parseInt(id);


        int indx = -1;
        for(int i=0; i<this.theStudents.size(); i++){
            if(this.theStudents.get(i).getStudentId() == idx){
                indx = i;
                break;
            }
        }

        if(indx == -1){
            long timeStamp = new Date().getTime();
            throw new CustomException("Studnet Not Found with Id = "+idx, 404);
        }
        return theStudents.get(indx);
    }
}
