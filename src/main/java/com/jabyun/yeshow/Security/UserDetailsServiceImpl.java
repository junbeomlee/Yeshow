package com.jabyun.yeshow.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.StringToLong;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired StoreRepository storeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String store_number) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Store store=null;
		try{
			store = storeRepository.findOne(StringToLong.convert(store_number));
			System.out.println(store.toString());
			if (store==null)
				throw new UsernameNotFoundException(store_number);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return new StoreDetailsImpl(store);
	}

}
