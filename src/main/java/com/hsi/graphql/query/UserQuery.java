package com.hsi.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hsi.graphql.entity.User;
import com.hsi.graphql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver{

    @Autowired
    private UserService userService;
    
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    public User getUserById() {
//        return userService.getUserById(Long.parseLong(dataFetchingEnvironment.getArgument("id")))	;
//        
//    }
}
