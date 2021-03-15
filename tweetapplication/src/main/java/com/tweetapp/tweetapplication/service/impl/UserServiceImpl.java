package com.tweetapp.tweetapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetapplication.dao.UserDao;
import com.tweetapp.tweetapplication.model.User;
import com.tweetapp.tweetapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User registerUser(User user) {
		return userDao.registerUser(user);
	}
	
	@Override
	public User userLogin(String emailid, String Password) {
		return userDao.userLogin(emailid,Password);
	}
	
	@Override
	public User changePassword(String emailid,String oldPassword, String newPassword) {
		return userDao.changePassword(emailid, oldPassword, newPassword);
	}

	@Override
	public User getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User userLogout(User user) {
		return userDao.userLogout(user);
	}
	

}
