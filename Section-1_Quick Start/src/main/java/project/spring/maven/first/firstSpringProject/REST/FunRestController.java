package project.spring.maven.first.firstSpringProject.REST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${account.name}")
    private String username;

    @Value("${account.profession}")
    private String profession;

    @GetMapping("/")
    String hello(){
        return "<h3> hello From Spring Boot</h3>";
    }

    @GetMapping("/checking")
    String changes(){
        return" <h2> Testing Spring Boot Dev Tools </h2>";
    }

    @GetMapping("/hello")
    String greeting(){
        return "Hello how are you?";
    }



//    System.out.print(username);
    @GetMapping("/Biodata")
    public String BioData(){
        return "Name : "+ username+ " Profession : "+ profession;
    }

}
