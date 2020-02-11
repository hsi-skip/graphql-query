package com.hsi.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hsi.graphql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

	@Autowired
    private UserService userService;

    public boolean delete(Long id) {
    	userService.delete(id);
    	
    	return true;
    }
}
