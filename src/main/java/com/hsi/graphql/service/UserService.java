package com.hsi.graphql.service;

import java.util.List;

import com.hsi.graphql.entity.User;

public interface UserService{

	public List<User> getAllUsers();
	
	public User getUserByEmail(String email);

	public void delete(User user);
	
	

}
