package com.control.of.inversion.Lec_2.Inversion.Of.Control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        /*
        for component scanning outside the spring boot
        package we need to explicitly mention it
        */
        /*
        scanBasePackages = {
                "com.control.of.inversion.Lec_2.Inversion.Of.Control",
                "com.control.of.inversion.util"
        }
        */
)
public class Lec2InversionOfControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lec2InversionOfControlApplication.class, args);
	}

}
