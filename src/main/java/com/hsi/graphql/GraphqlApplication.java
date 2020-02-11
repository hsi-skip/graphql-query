package com.hsi.graphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.service.UserService;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(UserService userService) {
		return (args) -> {
			User user1 = new User(1, "name 1", "0123456789", "email1@mail.com", "address 1");
			User user2 = new User(2, "name 2", "0123456789", "email2@mail.com", "address 2");
			User user3 = new User(3, "name 3", "0123456789", "email3@mail.com", "address 3");
			User user4 = new User(4, "name 4", "0123456789", "email4@mail.com", "address 4");
			User user5 = new User(5, "name 5", "0123456789", "email5@mail.com", "address 5");
			
			userService.save(user1);
			userService.save(user2);
			userService.save(user3);
			userService.save(user4);
			userService.save(user5);
		};
	}
	
}
