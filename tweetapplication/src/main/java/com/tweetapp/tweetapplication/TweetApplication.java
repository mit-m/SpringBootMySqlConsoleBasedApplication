package com.tweetapp.tweetapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tweetapp.tweetapplication.execption.IncorrectLoginCredentialsException;
import com.tweetapp.tweetapplication.execption.UserRegistrationException;
import com.tweetapp.tweetapplication.model.Tweet;
import com.tweetapp.tweetapplication.model.User;
import com.tweetapp.tweetapplication.service.TweetService;
import com.tweetapp.tweetapplication.service.UserService;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TweetApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory
		      .getLogger(TweetApplication.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TweetService tweetService;

	public static void main(String[] args) {
		SpringApplication.run(TweetApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");
      
        System.out.println("Welcome to tweet application !");
        
        int choice = 0;
        try {
        	
        	 Scanner sc = new Scanner(System.in);
             
             do {
             	System.out.println("Which operation do you want to perform ? :");
             	System.out.println("\t1. Register\t2. Login\t3.Change Password\t4.Exit");
             	System.out.print("\n Choice :\t");
             	choice = sc.nextInt();
             	
             	switch(choice) {
             	case 1:{
             		System.out.println("Register User - ");
             		System.out.print("\nEnter the required information - ");
             		String firstName,lastName,gender,dob,emailid,password;
             		boolean isLoggedIn = false;
             		
             		System.out.print("\nFirst Name :\t");
             		firstName = sc.next();
             		
             		System.out.print("\nLast Name :\t");
             		lastName = sc.next();
             		
             		System.out.print("\nGender :\t");
             		gender = sc.next();
             		
             		System.out.print("\nDate Of Birth (MM-dd-yyyy) :\t");
             		dob = sc.next();
             		
             		System.out.print("\nEmail Id :\t");
             		emailid = sc.next();
             		
             		System.out.print("\nPassword :\t");
             		password = sc.next();
             		
             		SimpleDateFormat sdf1 = new SimpleDateFormat(dob);
             		java.util.Date date = sdf1.parse(dob);
             		java.sql.Date sqldob = new java.sql.Date(date.getTime()); 
             	   
             		User newUser = new User(emailid, firstName, lastName, gender, sqldob, password, isLoggedIn);        	    
             		System.out.println("***Register User Functionality - ");
             		
             		User registeredUser = userService.registerUser(newUser);
             			
             		if(registeredUser == null) {
                    	throw new UserRegistrationException("Error while registering user!");	
                    }
             		else {

                 	    System.out.println("User registered succesfully !");
                 		System.out.println(registeredUser.toString());
             		}
             			
             		
             		break;
             	}
             	case 2:{
             		System.out.println("User Login - ");
             		System.out.print("\nEnter the required information - ");
             		String emailid,password;
             		
             		System.out.print("\nEmail Id :\t");
             		emailid = sc.next();
             		
             		System.out.print("\nPassword :\t");
             		password = sc.next();
             		
             	
             		User loggedInUser = userService.userLogin(emailid,password);
             		if(loggedInUser == null) {
             		 throw new IncorrectLoginCredentialsException("Error while loggin in ! Incorrect credentials!");	
             		}
             		else {
             			System.out.println(loggedInUser.getEmailid() + " - logged in succesfully !");
             			System.out.println(loggedInUser.toString());
             			
             			//menu for logged in user
             			int choiceAfterLogin = 0;
             			do {
             				
             				System.out.println("\n\n*Hi - " + loggedInUser.getEmailid() + " Which operation do you want to perform ? :");
             	        	System.out.println("\n\t1. Post Tweet\n\t2. View My Tweets\n\t3. View All Tweets\n\t4. View All Users\n\t5. Change Password\n\t6. Logout");
             	        	System.out.print("\n Choice :\t");
             	        	choiceAfterLogin = sc.nextInt();
             	        	
             	        	switch(choiceAfterLogin) {
             	        	case 1:{
             	        		Tweet tweet = new Tweet();
     							tweet.setEmailid(loggedInUser); //emailid is the unique user id 
     							System.out.println("Enter tweet description - ");
     							sc.nextLine();
     							String tweetcontent = sc.nextLine();

     							tweet.setTweet_content(tweetcontent);
     						    
             	        		Tweet postedTweet = tweetService.postTweet(tweet);
                 	        		
             	        		if(postedTweet == null) {
             	        			throw new Exception();		
             	        		}
             	        		else {
             	        			System.out.println("Tweet posted successfully!");
             	        		}
             	        	
             	        		
             	        		break;
             	        	}
             	        	case 2:{
             	        		System.out.println("Tweets by - "+loggedInUser.getEmailid());
             	        		List<Tweet> tweetsByLoggedInUser = tweetService.viewUsersTweets(loggedInUser);
             	        		
             	        		if(tweetsByLoggedInUser.size()==0) {
             	        			System.out.println("No tweets posted by this user!");
             	        		}
             	        		
             	        		for(int i=0;i<tweetsByLoggedInUser.size();i++) {
             	        			System.out.print("\nTweet -"+ (i+1));
             	        			System.out.print("\t"+tweetsByLoggedInUser.get(i).getTweet_content()+"\n");
             	        		}
             	        		
             	        		break;
             	        	}
             	        	case 3:{
             	        		
             	        		System.out.println("All tweets ");
             	        		List<Tweet> tweets = tweetService.viewAllTweets();             	        		
             	        		if(tweets.size()==0) {
             	        			System.out.println("No tweets posted by this user!");
             	        		}
             	        		else {
             	        		 for(int i=0;i<tweets.size();i++) {
             	        			System.out.print("\nTweet -"+ (i+1));
             	        			System.out.print("\t Tweets By - "+ tweets.get(i).getUserId());
             	        			System.out.print("\t Tweets Content - "+tweets.get(i).getTweet_content()+"\n");
             	        		 }
             	        		}
             	        			
             	        		break;
             	        	}
             	        	case 4:{
             	        		
             	        		System.out.println("\nAll Uesrs Of Tweet App - ");
             	        		List<User> users = userService.getAllUsers();
             	        		
             	        		if(users.size()==0) {
             	        			System.out.println("Currently no users registered in the system !");
             	        		}
             	        		
             	        		else {
             	        			for(int i=0;i<users.size();i++) {
             	        				System.out.println("\t"+(i+1)+"\t"+users.get(i).getEmailid());
             	        			}
             	        		}
             	        		
             	        		break;
             	        	}
             	        	case 5:{
             	        		System.out.println("Change Password - ");
                         		System.out.print("\nEnter the required information - ");
                         		String newpw;
                         		
                         		System.out.print("\nNew Password :\t");
                         		newpw = sc.next();
                         		
                         		User user = userService.changePassword(loggedInUser.getEmailid(), loggedInUser.getPassword(), newpw);
                         		if(user == null) {
                         		 throw new Exception();	
                         		}
                         		else {
                         			System.out.println(user.getEmailid() + " - password changed succesfully !");
                         			System.out.println(user.toString());
                         			loggedInUser.setPassword(newpw);
                         		}
                         		
             	        		break;
             	        	}
             	        	case 6:{
             	        		User user = userService.userLogout(loggedInUser);
             	        		if(user == null) {
                            		 throw new Exception();	
                            	}
                            	else {
                            		System.out.println(user.getEmailid()+ " logged out successfully!");
                            	}
             	        		break;
             	        	}
             	        	default:{
             	        		System.out.println("Please enter a valid choice!");
             	        	}
             	        	
             	        	}
             					
             			}while(choice!=6);
             			
             		
             		}
             		
             		
             		break;
             	}
             	case 3:{
             		
             		System.out.println("Forgot Password - ");
             		System.out.print("\nEnter the required information - ");
             		String emailid,oldpw,newpw;
             		
             		System.out.print("\nEmail Id :\t");
             		emailid = sc.next();
             		
             		System.out.print("\nOld Password :\t");
             		oldpw = sc.next();
             		
             		System.out.print("\nNew Password :\t");
             		newpw = sc.next();
             			
             		User user = userService.changePassword(emailid, oldpw, newpw);
                 	if(user == null) {
                 		throw new Exception();	
                 	}
                 	else {
                 		System.out.println(user.getEmailid() + " - password changed succesfully !");
                 		System.out.println(user.toString());
                 	}

             		break;
             	}
             	case 4:{
             		break;
             	}
             	default:{
             		System.out.println("Please enter a valid choice!");
             	}
             	}
             	
             }while(choice!=4);

        	
        }catch(Exception e) {
        	LOG.error("Error  :"+ e.getMessage());
        }
          
    }


}


