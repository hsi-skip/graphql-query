package com.hsi.graphql.service.implementation.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;
import com.hsi.graphql.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplementationTest {

	@Mock
	@Autowired
	private UserRepository mockedUserRepository;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void save() {
		
	     User user = new User(1, "name 1", "0123456789", "email1@email.com", "address 1");
	     when(mockedUserRepository.findOne(user.getId())).thenReturn(null);
	     when(mockedUserRepository.findByEmail(user.getEmail())).thenReturn(null);
	    

	     //Create sample User object and set all the properties
	     User newUser = new User();
	     newUser.setId(2);
	     newUser.setName(newUser.getName());
	     newUser.setPhone(newUser.getPhone());
	     newUser.setEmail(newUser.getEmail());
	     newUser.setAddress(newUser.getAddress());
	     
	     when(mockedUserRepository.save(Mockito.any(User.class))).thenReturn(newUser);
	     User returnedUser = userService.save(user);
	     //You have two ways to test, you can either verify that save method was invoked by 
	     //verify method
	     verify(mockedUserRepository, times(1)).save(Mockito.any(User.class));
	     //or by assertion statements, match the authToken in the returned object to be equal 
	     //to the one set by you in the mocked object
	     //Assert.assertEquals(returnedUser.getAuthToken(),newUser.getAuthToken());
	     
	}
	
	
//	deletegetUserById
//	getUserByEmail
//	getAllUsers
	
}
