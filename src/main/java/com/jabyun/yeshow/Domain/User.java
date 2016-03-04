package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="tokenID")
	private long tokenID;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_phone")
	private String user_phone;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="user_freq")
	private int user_freq;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="point")
	private int point;

	@Column(name="role")
	private String role;

	public User(){}

	public User(long tokenID, String user_name, String user_phone, String gender, int user_freq,String grade,
			int point, String role) {
		super();
		this.tokenID = tokenID;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.gender = gender;
		this.user_freq = user_freq;
		this.grade = grade;
		this.point = point;
		this.role = role;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getUser_freq() {
		return user_freq;
	}


	public void setUser_freq(int user_freq) {
		this.user_freq = user_freq;
	}

	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
