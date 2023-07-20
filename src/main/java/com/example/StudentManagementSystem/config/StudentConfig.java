package com.example.StudentManagementSystem.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandlinerunner(StudentRepository studentRepository) {
		
		return args ->{
			Student kulani = new Student(
					"Kulani",
					"Khosa",
					"kulani@gmail.com"
					);
			
			Student allen = new Student(
					"Allen",
					"Nukeri",
					"nukeri@gmail.com"
					);
			
			Student ernie = new Student(
					"Ernie",
					"Shikweni",
					"ernie@gmail.com"
					);
			
			studentRepository.saveAll(List.of(kulani, allen, ernie));
			
		};
		
	}
}
