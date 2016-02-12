package com.jabyun.yeshow.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Util.StringToLong;

@Component
public class FacebookManager {

	@Autowired
	Facebook facebook;
	private FacebookProfile facebookProfile;
	
	public FacebookManager(){}
	
	public void setFacebook(String accessToken){
		facebook = new FacebookTemplate(accessToken);
		facebookProfile = facebook.userOperations().getUserProfile();
	}

	public User bindUser(User user) {
		// TODO Auto-generated method stub
		user.setTokenID(StringToLong.convert(facebookProfile.getId()));
		user.setUser_name(facebookProfile.getName());
		user.setGender(facebookProfile.getGender());
		user.setGrade("일반고객");
		
		return user;
	}
	
	public String getTokenID(){
		return facebookProfile.getId();
	}
}
