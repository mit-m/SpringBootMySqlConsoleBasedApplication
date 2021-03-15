package com.tweetapp.tweetapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweetapplication.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{
	
	@Query(value = "SELECT * FROM tweet  WHERE emailid = ?1",nativeQuery=true)
	List<Tweet> findTweetsByUserId(String emailid);
	
	@Query(value = "SELECT * FROM tweet  ORDER BY emailid",nativeQuery=true)
	List<Tweet> findTweets();
}
