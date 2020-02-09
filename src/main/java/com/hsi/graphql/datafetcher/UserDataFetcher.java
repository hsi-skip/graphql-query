package com.hsi.graphql.datafetcher;

import com.hsi.graphql.entity.User;
import com.hsi.graphql.service.UserService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher {

    @Autowired
    private UserService userService;

    public DataFetcher getUserById(){
        return dataFetchingEnvironment -> userService
                .getUserById(dataFetchingEnvironment.getArgument("id"))
                .orElse(new User() );
    }

    public DataFetcher getUserByEmail(){
        return dataFetchingEnvironment -> userService
                .getUserById(dataFetchingEnvironment.getArgument("email"))
                .orElse(new User() );
    }

    public DataFetcher getAllUsers(){
        return dataFetchingEnvironment -> userService.getAllUsers();
    }

    public DataFetcher delete() {
        return dataFetchingEnvironment -> userService.delete(dataFetchingEnvironment.getArgument("id"));
    }


}
