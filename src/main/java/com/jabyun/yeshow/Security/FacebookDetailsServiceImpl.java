package com.jabyun.yeshow.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jabyun.yeshow.Domain.FacebookManager;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Domain.UserSpecification;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.StringToLong;

@Service("FacebookDetailsServiceImpl")
public class FacebookDetailsServiceImpl implements UserDetailsService{

	@Autowired
	FacebookManager facebookManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserSpecification userSpecification;
	
	@Override
	public UserDetails loadUserByUsername(String tokenID) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		facebookManager.setFacebook(tokenID);
		
		User user=userSpecification.isExist(StringToLong.convert(facebookManager.getTokenID()));
		if(user!=null){
			//이미존재 
		}else{
			//존재 안함
			user=new User();
			facebookManager.bindUser(user);
			user.setRole("ROLE_USER");
			userRepository.save(user);
		}
		
		return new FacebookDetailsImpl(user);
	}
}
