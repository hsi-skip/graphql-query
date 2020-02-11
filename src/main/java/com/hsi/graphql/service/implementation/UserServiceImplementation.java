package com.hsi.graphql.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;
import com.hsi.graphql.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) { 
		return userRepository.findById(id); 
	}

	@Override
	public User getUserByEmail(String email) { 
		return userRepository.findByEmail(email); 
	}

	@Override
	public List<User> getAllUsers() { 
		return userRepository.findAll(); 
	}

	@Override
	public boolean delete(long id) { 
		userRepository.delete(id);
		
		return true;
	}
	
}
