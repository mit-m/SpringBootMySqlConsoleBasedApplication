package com.tweetapp.tweetapplication.dao;

import java.util.List;

import com.tweetapp.tweetapplication.model.User;

public interface UserDao {
	
	User registerUser(User user);
	User userLogin(String emailid, String Password);
	User changePassword(String emailid,String oldPassword, String newPassword);
	User getUserByUserId(String userId);
	List<User> getAllUsers();
	User userLogout(User user);

}
