package com.jabyun.yeshow.test.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.User;

@Component
public class UserFactory {

	private static UserFactory userFactory = new UserFactory();

	public UserFactory(){}
	
	public static UserFactory getInstance(){
		return userFactory;
	}
	public User makeUserEntity(long userNum,String name){
		User newUser = new User();
		newUser.setTokenID(userNum);
		newUser.setUser_name(name);
		return newUser;
	}
}
