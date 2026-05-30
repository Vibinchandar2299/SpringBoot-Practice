package com.example.FirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		Student s = context.getBean(Student.class);
		s.study();
    }

}

