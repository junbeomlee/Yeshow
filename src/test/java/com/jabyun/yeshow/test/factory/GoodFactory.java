package com.jabyun.yeshow.test.factory;

import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;

@Component
public class GoodFactory {

	public Good makeGoodEntity(User user,Store store){
		Good good= new Good();
		good.setUser(user);
		good.setStore(store);
		return good;
	}

}
