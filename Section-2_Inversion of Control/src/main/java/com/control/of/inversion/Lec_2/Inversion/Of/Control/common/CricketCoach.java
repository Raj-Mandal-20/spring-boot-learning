package com.control.of.inversion.Lec_2.Inversion.Of.Control.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("Constructor init : "+getClass().getSimpleName());
    }

    // Bean lifecycle
    /*

        // do our init method
        @PostConstruct
        public void doMyStartupStuff(){
            System.out.println("Starting up my class : "+getClass().getSimpleName());
        }

        // do our destroy method
        @PreDestroy
        public void doMyCleanupStuff(){
            System.out.println("cleaning up my class : "+getClass().getSimpleName());
        }
    */



    @Override
    public String DailyWorkOut() {
        return "Practice Fast Bowling For 15 Minute :)";
    }
}
