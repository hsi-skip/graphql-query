package com.hsi.graphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.repository.UserRepository;
import com.hsi.graphql.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public void saveAll(List<User> lstUser) {
		userRepository.saveAll(lstUser);
	}
	
}
