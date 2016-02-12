package com.jabyun.yeshow.test.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Promotion;
import com.jabyun.yeshow.Domain.Store;

@Component
public class StoreFactory {
	
	public StoreFactory(){
		
	}
	
	public Store makeStoreEntity(long storeNum,String storeName){
		Store store= new Store();
		store.setStore_number(storeNum);
		store.setStore_name(storeName);
		return store;
	}
	
	public Promotion makePromotion(String promotionName,String promotionContents){
		
		Promotion promotion = new Promotion();
		promotion.setPromotion_contents(promotionContents);
		promotion.setPromotion_name(promotionName);
		
		return promotion;
	}
}
