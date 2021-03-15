package com.tweetapp.tweetapplication.model;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @Column(name = "emailid", nullable = false)
    private String emailid;
     
    @Column(name = "first_name")
    private String first_name;
     
    @Column(name= "last_name")
    private String last_name;
    
    @Column(name= "gender")
    private String gender;
    
    @Basic
    @Column(name= "date_of_birth")
    private java.sql.Date date_of_birth;
    
    @Column(name= "password")
    private String password;
    
    @Column(name= "is_loggedin")
    private boolean is_loggedin;

    @OneToMany(mappedBy = "emailid")
	private List<Tweet> tweets;

	
	public User() {
		super();
		
	}
	

	public User(String emailid, String first_name, String last_name, String gender, Date sqlDate, String password,
			boolean is_loggedin) {
		super();
		this.emailid = emailid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.date_of_birth = sqlDate;
		this.password = password;
		this.is_loggedin = is_loggedin;
	}


	
	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public java.sql.Date getDateOfBirth() {
		return date_of_birth;
	}


	public void setSqlDate(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isIs_loggedin() {
		return is_loggedin;
	}


	public void setIs_loggedin(boolean is_loggedin) {
		this.is_loggedin = is_loggedin;
	}


	@Override
	public String toString() {
		return "User [emailid=" + emailid + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", sqlDate=" + date_of_birth + ", password=" + password + ", is_loggedin=" + is_loggedin + "]";
	}
     
}

