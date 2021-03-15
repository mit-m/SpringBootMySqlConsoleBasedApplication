package com.tweetapp.tweetapplication.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetapplication.dao.UserDao;
import com.tweetapp.tweetapplication.model.User;
import com.tweetapp.tweetapplication.repository.UserRepository;

@Service
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User userLogin(String emailid, String password) {
		User user = getUserByUserId(emailid);
		
		if(user != null && user.getPassword().equals(password)) {
			user.setIs_loggedin(true);
			return userRepository.save(user);
		}
		
		else {
			return null;
		}
		
	}
	
	@Override
	public User changePassword(String emailid,String oldPassword, String newPassword) {
		User user = getUserByUserId(emailid);
		
		if(user != null && user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			return userRepository.save(user);
		}
		
		else {
			return null;
		}
	}


	@Override
	public User getUserByUserId(String userId) {
		User user = userRepository.findById(userId).get();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User userLogout(User user) {
		user.setIs_loggedin(false);
		return userRepository.save(user);
	}
	
	

}
