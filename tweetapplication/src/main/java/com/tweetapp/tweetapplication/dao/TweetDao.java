package com.tweetapp.tweetapplication.dao;

import java.util.List;

import com.tweetapp.tweetapplication.model.Tweet;
import com.tweetapp.tweetapplication.model.User;

public interface TweetDao {
	
	Tweet postTweet(Tweet tweet);
	List<Tweet> viewUsersTweets(User user);
	List<Tweet> viewAllTweets();

}
