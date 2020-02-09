package com.hsi.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.service.UserService;


@SpringBootApplication
public class GraphqlApplication {//implements ApplicationRunner {

	@Autowired 
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}	

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		List<User> lstUser = new ArrayList<User>();
//
//		lstUser.add(new User("name 1", "0123456789", "email 1", "address 1"));
//		lstUser.add(new User("name 2", "0123456789", "email 2", "address 2"));
//		lstUser.add(new User("name 3", "0123456789", "email 3", "address 3"));
//		lstUser.add(new User("name 4", "0123456789", "email 4", "address 4"));
//		lstUser.add(new User("name 5", "0123456789", "email 5", "address 5"));
//		
//		userService.saveAll(lstUser);
//	}
	
}
