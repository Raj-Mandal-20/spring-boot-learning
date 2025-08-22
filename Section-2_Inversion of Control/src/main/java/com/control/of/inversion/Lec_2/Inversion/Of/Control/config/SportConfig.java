package com.control.of.inversion.Lec_2.Inversion.Of.Control.config;

import com.control.of.inversion.Lec_2.Inversion.Of.Control.common.Coach;
import com.control.of.inversion.Lec_2.Inversion.Of.Control.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
