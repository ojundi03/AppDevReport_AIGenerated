package com.petso1.petso1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PetsO1Application {

    public static void main(String[] args) {
        SpringApplication.run(PetsO1Application.class, args);
    }

}
