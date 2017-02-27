package edu.uade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="edu.uade")
public class SamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamApplication.class, args);
	}
}
