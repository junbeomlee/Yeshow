package com.jabyun.yeshow.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;

@Component
public class Collector {
	
	@Autowired StoreRepository storeRepository;
	@Autowired UserRepository userRepository;

	private List<Object> objectList = new ArrayList<Object>();
	
	
	public void put(Object object){
		objectList.add(object);
	}
	
	public void clearAll(){
		for(int i=0;i<this.objectList.size();i++){
			Object object = this.objectList.get(i);
			if(object instanceof User){
				userRepository.delete((User)object);
			}else if(this.objectList.get(i) instanceof Store){
				storeRepository.delete((Store)object);
			}
		}
		
	}
}
