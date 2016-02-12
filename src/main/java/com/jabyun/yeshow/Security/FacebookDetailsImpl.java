package com.jabyun.yeshow.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.jabyun.yeshow.Domain.Store;

public class FacebookDetailsImpl extends User{

	public FacebookDetailsImpl(com.jabyun.yeshow.Domain.User user){
		
		super(String.valueOf(user.getTokenID()), String.valueOf(user.getTokenID()), authorities(user));
	}
	
	private static Collection<? extends GrantedAuthority> authorities(com.jabyun.yeshow.Domain.User user){
		System.out.println(user.toString());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return authorities;
	}
}

