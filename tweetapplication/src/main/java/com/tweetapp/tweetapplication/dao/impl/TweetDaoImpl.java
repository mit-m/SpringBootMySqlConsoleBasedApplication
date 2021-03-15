package com.tweetapp.tweetapplication.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweetapplication.dao.TweetDao;
import com.tweetapp.tweetapplication.model.Tweet;
import com.tweetapp.tweetapplication.model.User;
import com.tweetapp.tweetapplication.repository.TweetRepository;


@Service
@Transactional
public class TweetDaoImpl implements TweetDao {
	
	@Autowired
	private TweetRepository tweetRepository;

	@Override
	public Tweet postTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

	@Override
	public List<Tweet> viewUsersTweets(User user) {
		return tweetRepository.findTweetsByUserId(user.getEmailid());
	}

	@Override
	public List<Tweet> viewAllTweets() {	
		return tweetRepository.findTweets();
	}	
}
