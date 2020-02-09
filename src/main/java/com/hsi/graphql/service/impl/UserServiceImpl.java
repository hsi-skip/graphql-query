package com.hsi.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;
import com.hsi.graphql.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(long id) { return userRepository.findById(id); }

	@Override
	public Optional<User> getUserByEmail(String email) { return userRepository.findByEmail(email); }

	@Override
	public List<User> getAllUsers() { return (List<User>)userRepository.findAll(); }

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
