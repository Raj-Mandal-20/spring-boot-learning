package com.control.of.inversion.Lec_2.Inversion.Of.Control.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String DailyWorkOut() {
        return "Daily 30 min Practice of Base Ball :)";
    }
}
