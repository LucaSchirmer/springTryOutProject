package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){

		return args ->{
			Student Marlene = new Student(
					1L,
					"Marlene",
					"Marlene@gmail.com",
					LocalDate.of(2001,
							Month.FEBRUARY,
							4),
					22);
			studentRepository.save(Marlene);
		};
	}

}
