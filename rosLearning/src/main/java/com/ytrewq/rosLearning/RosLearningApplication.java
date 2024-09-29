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
/*
		User employee = new User("1","2","#","4");
		employee.setEmail("george@mail.ru");
		employee.setPosition("employer");
		employee.setRegistration_date("22-02-2003");
		employee.setFio("Abo");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
*/

		SpringApplication.run(RosLearningApplication.class, args);
	}

}
