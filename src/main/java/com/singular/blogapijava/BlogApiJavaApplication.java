package com.singular.blogapijava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BlogApiJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiJavaApplication.class, args);
	}

}
