package com.control.of.inversion.Lec_2.Inversion.Of.Control.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String DailyWorkOut() {
        return "Daily 1Hour Practice of Tennis :)";
    }
}
