package com.jabyun.yeshow.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Repository.UserRepository;

@Component
public class UserSpecification {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserSpecification(){}
	
	public User isExist(long tokenID){
		
		User user=this.userRepository.findOne(tokenID);
		
		return user;
	}
}
