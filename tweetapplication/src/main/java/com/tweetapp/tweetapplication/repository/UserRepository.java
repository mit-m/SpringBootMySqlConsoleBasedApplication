package com.tweetapp.tweetapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweetapplication.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
