package com.hsi.graphql.service;

import java.util.List;

import com.hsi.graphql.entity.User;

public interface UserService{

	public User save(User user);	

	public User getUserById(long id);

	public User getUserByEmail(String email);

	public List<User> getAllUsers();

	public boolean delete(long id);

}
