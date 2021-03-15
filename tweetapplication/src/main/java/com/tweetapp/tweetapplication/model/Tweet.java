package com.tweetapp.tweetapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tweet")
public class Tweet {
	
	@Id
    @Column(name = "tweetid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tweetid;
     
    @Column(name = "tweet_content")
    private String tweet_content;
 
    @ManyToOne
	@JoinColumn(name = "emailid")
	private User emailid;

	public Tweet() {
		super();
		
	}

	
	public Integer getTweetid() {
		return tweetid;
	}

	public void setTweetid(Integer tweetid) {
		this.tweetid = tweetid;
	}

	public String getTweet_content() {
		return tweet_content;
	}

	public void setTweet_content(String tweet_content) {
		this.tweet_content = tweet_content;
	}

	

	public User getEmailid() {
		return emailid;
	}


	public void setEmailid(User emailid) {
		this.emailid = emailid;
	}
	
	public String getUserId() {
		return emailid.getEmailid();
	}


	@Override
	public String toString() {
		return "Tweet [tweetid=" + tweetid + ", tweet_content=" + tweet_content + ", userid=" + emailid + "]";
	}

}
