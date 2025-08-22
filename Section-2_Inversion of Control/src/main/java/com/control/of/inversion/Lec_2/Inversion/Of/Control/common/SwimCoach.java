package com.control.of.inversion.Lec_2.Inversion.Of.Control.common;

import org.springframework.context.annotation.Configuration;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("constructor call : "+ getClass().getSimpleName());
    }


    @Override
    public String DailyWorkOut() {
        return "Swim 1000m as a worm up";
    }
}
