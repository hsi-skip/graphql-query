package com.hsi.graphql.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;
import com.hsi.graphql.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;
	
	@Test
	public void getAllUsers(){
		when(userRepository.findAll()).thenReturn (Stream.of(
				new User(1, "name 1", "0987654321", "email1@mail.com", "address 1"),
				new User(2, "name 2", "0987654321", "email2@mail.com", "address 2")).collect(Collectors.toList())
		);
		
		assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void delete() {
		User user = new User(2, "name 2", "0987654321", "email2@mail.com", "address 2"); 
		userService.delete(user);
		verify(userRepository, times(1)).delete(user);
	}
}
