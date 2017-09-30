package edu.uade.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author msarno
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "edu.uade")
// @EnableAutoConfiguration
@PropertySources({ 
	@PropertySource("classpath:application.properties"), 
	@PropertySource("classpath:auth0.properties") 
})
public class SamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamApplication.class, args);
	}
}
