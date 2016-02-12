package com.jabyun.yeshow.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.jabyun.yeshow.Domain.Store;

public class StoreDetailsImpl extends User{

	public StoreDetailsImpl(Store store){
		
		super(String.valueOf(store.getStore_number()), store.getStore_password(), authorities(store));
	}
	
	private static Collection<? extends GrantedAuthority> authorities(Store store){
		System.out.println(store.toString());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(store.getRole()));
		return authorities;
	}
}
