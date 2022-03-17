package com.shristi;

import com.shristi.setter.Address;
import com.shristi.setter.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Autowired
	Employee employee;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("employee = " + employee);

	}
}
