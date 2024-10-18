package com.ytrewq.rosLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RosLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(RosLearningApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:63342")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*")
						.allowCredentials(true);
//				registry.addMapping("/api/csrf").allowedOrigins("http://localhost:63342");
//				registry.addMapping("/api/login").allowedOrigins("http://localhost:63342").allowedMethods("GET", "POST", "PUT", "DELETE")
				;

			}
		};
	}
}
