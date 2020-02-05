package com.hsi.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsi.graphql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
