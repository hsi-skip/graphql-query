package com.hsi.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsi.graphql.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByEmail(String email);

}
