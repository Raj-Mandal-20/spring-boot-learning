package com.control.of.inversion.Lec_2.Inversion.Of.Control.rest;

import com.control.of.inversion.Lec_2.Inversion.Of.Control.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a Private Field for Dependency
    private Coach myCoach;
    private Coach anotherCoach;
    private Coach baseballCoach;
    private Coach tennisCoach;
    private Coach trackCoach;
    private Coach cricketCoach;

    /*

    // define a constructor for dependency injection
    // constructor injection used when you have required dependencies
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    */


    /* setterInjection
    * Setter Injection used when you have option dependencies
    *
    * @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
    *
    * I can use any name of the method in setter injection
    *  @Autowired
    public void doSomeStuff(Coach theCoach){
        myCoach = theCoach;
    }
    */

    /*@Autowired
    public DemoController(@Qualifier("cricketCoach")Coach theCoach, @Qualifier("cricketCoach")Coach otherCoach){
        System.out.println(getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = otherCoach;

        System.out.println(myCoach==anotherCoach);
    }*/

    @Autowired
    public DemoController(@Qualifier("aquatic")Coach theCoach){
        System.out.println(getClass().getSimpleName());
        myCoach = theCoach;
    }

    /*setter injection practice with implementing all the coaches */
    /*
    @Autowired
    public void setTrackCoach(@Qualifier("trackCoach") Coach theCoach){
        trackCoach = theCoach;
    }

    @Autowired
    public void setTennisCoach(@Qualifier("tennisCoach") Coach theCoach){
        tennisCoach = theCoach;
    }

    @Autowired
    public void setCricketCoach(@Qualifier("cricketCoach") Coach theCoach){
        cricketCoach = theCoach;
    }

    @Autowired
    public void setBaseballCoach(@Qualifier("baseballCoach")Coach theCoach){
        baseballCoach = theCoach;
    }
    */

    /*Constructor injection using primary*/

    /*
    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.DailyWorkOut();
    }*/


    /*Mapping for testing setter injection*/
    /*
    @GetMapping("/baseball")
    public String basecallCoach(){
         return baseballCoach.DailyWorkOut();
    }

    @GetMapping("/tennis")
    public String tennisCoach(){
        return tennisCoach.DailyWorkOut();
    }

    @GetMapping("/cricket")
    public String baseballCoach(){
        return cricketCoach.DailyWorkOut();
    }
    @GetMapping("/track")
    public String trackCoach(){
        return trackCoach.DailyWorkOut();
    }*/

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
//        return "is same "+ (myCoach==anotherCoach);
        return myCoach.DailyWorkOut();
    }



}
