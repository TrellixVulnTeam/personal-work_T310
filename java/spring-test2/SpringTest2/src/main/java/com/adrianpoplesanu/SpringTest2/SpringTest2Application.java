package com.adrianpoplesanu.SpringTest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTest2Application {
	// spring-test contains the actual way of doing this

	public static void main(String[] args) {
		SpringApplication.run(SpringTest2Application.class, args);
	}

}
