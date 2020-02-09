package com.hsi.graphql.service;

import java.util.List;
import java.util.Optional;

import com.hsi.graphql.entity.User;

public interface UserService{

	public User save(User user);

	public Optional<User> getUserById(long id);

	public Optional<User> getUserByEmail(String email);

	public List<User> getAllUsers();

	public User delete(User user);

}
