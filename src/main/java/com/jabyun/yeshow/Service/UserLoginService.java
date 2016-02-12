package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.AgeRange;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.FacebookManager;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Domain.UserSpecification;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.StringToLong;

@Component("UserLoginService")
public class UserLoginService extends YeshowService {

	@Autowired
	FacebookManager facebookManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserSpecification userSpecification;
	
	UserLoginService() {}
	/**
	 * 
	 * @param tokenID
	 * 
	 *            1. existing user -> return userObject 2 non existing user ->
	 *            add and return userObject
	 */
	@Override
	@Transactional
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		/**
		 * dataObject
		 * 	type=long
		 * 	name=access_token
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		facebookManager.setFacebook((String) dataObject.get("access_token"));
		
		User user=userSpecification.isExist(StringToLong.convert(facebookManager.getTokenID()));
		if(user!=null){
			//이미존재 
		}else{
			//존재 안함
			user=new User();
			facebookManager.bindUser(user);
			userRepository.save(user);
		}
		
		listFinalData.add(user);
		
		
		return listFinalData;
	}
	
}
