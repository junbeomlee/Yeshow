package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Non_user")
public class Non_user {
	
	@Id
	@Column(name="tokenID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tokenID;

	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_phone")
	private String user_phone;
	
	public Non_user(){}
	
	public Non_user(long tokenID, String user_name, String user_phone) {
		super();
		this.tokenID = tokenID;
		this.user_name = user_name;
		this.user_phone = user_phone;
	}


	public long getTokenID() {
		return tokenID;
	}

	public void setTokenID(long tokenID) {
		this.tokenID = tokenID;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	
	
}
