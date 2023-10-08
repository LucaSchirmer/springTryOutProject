package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean // makes it run
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){

        return args ->{
            Student Marlene = new Student(
                    "Marlene",
                    "Marlene@gmail.com",
                    LocalDate.of(2001,
                            Month.FEBRUARY,
                            4)
            );

            Student Alex = new Student(
                    "Alex",
                    "Alex@gmail.com",
                    LocalDate.of(2003,
                            Month.MARCH,
                            5)
            );

            studentRepository.saveAll(List.of(Alex, Marlene));
        };
    }
}
