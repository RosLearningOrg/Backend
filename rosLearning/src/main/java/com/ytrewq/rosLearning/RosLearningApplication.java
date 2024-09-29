package com.ytrewq.rosLearning;

import com.ytrewq.rosLearning.entities.Role;
import com.ytrewq.rosLearning.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RosLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(RosLearningApplication.class, args);
	}

}
