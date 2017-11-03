package edu.uade.sam;

import org.springframework.beans.factory.annotation.Value;
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
@ComponentScan(basePackages="edu.uade")
@PropertySources({ 
	@PropertySource("classpath:application.properties")
})
public class SamApplication {

	@Value("${cors.config.allowed-origins}")
	private String allowedOrigins;

	public static void main(String[] args) {
		SpringApplication.run(SamApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
