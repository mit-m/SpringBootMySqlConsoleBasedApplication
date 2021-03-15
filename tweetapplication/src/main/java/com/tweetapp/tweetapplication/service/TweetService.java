package com.tweetapp.tweetapplication.service;

import java.util.List;

import com.tweetapp.tweetapplication.model.Tweet;
import com.tweetapp.tweetapplication.model.User;

public interface TweetService {
	
	Tweet postTweet(Tweet tweet);
	List<Tweet> viewUsersTweets(User user);
	List<Tweet> viewAllTweets();

}
