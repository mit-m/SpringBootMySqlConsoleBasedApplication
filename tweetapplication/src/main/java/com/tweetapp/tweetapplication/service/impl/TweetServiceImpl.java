package com.tweetapp.tweetapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetapplication.dao.TweetDao;
import com.tweetapp.tweetapplication.model.Tweet;
import com.tweetapp.tweetapplication.model.User;
import com.tweetapp.tweetapplication.service.TweetService;

@Service
public class TweetServiceImpl implements TweetService{
	
	@Autowired
	private TweetDao tweetDao;

	@Override
	public Tweet postTweet(Tweet tweet) {
		return tweetDao.postTweet(tweet);
	}

	@Override
	public List<Tweet> viewUsersTweets(User user) {
		return tweetDao.viewUsersTweets(user);
	}

	@Override
	public List<Tweet> viewAllTweets() {
		return tweetDao.viewAllTweets();
	}
	

}
