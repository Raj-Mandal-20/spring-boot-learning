package com.control.of.inversion.Lec_2.Inversion.Of.Control.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String DailyWorkOut(){
        return "Practice 10km Running on Track Everyday :)";
    }

}
