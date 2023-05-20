package com.atos.questionbankmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.atos.repository")
@ComponentScan("com.atos.*")
public class QuestionBankMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionBankMicroserviceApplication.class, args);
	}

}
