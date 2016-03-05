package com.jabyun.yeshow.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jabyun.yeshow.Springboot2Application;
import com.jabyun.yeshow.Domain.Promotion;
import com.jabyun.yeshow.Domain.Store;
//import com.jabyun.yeshow.Repository.PromotionRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.test.factory.StoreFactory;
import com.jabyun.yeshow.test.util.InstanceTestClassListener;
import com.jabyun.yeshow.test.util.InstanceTestClassRunner;
import com.jabyun.yeshow.test.util.ObserverCollector;

import junit.framework.Assert;

@RunWith(InstanceTestClassRunner.class)
@SpringApplicationConfiguration(classes = Springboot2Application.class)
@WebAppConfiguration
@Component
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class PromotionTests implements InstanceTestClassListener {

	@Autowired private StoreRepository storeRepository;
	@Autowired private StoreFactory storeFactory;
	@Autowired private ObserverCollector observerCollector; 
	
	@Override
	public void beforeClassSetup() {}

	@Override
	public void afterClassSetup() {
		//observerCollector.clearAll();
		//System.out.println("asd");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void addPromotion() {
		/**
		 * requestData format { 
		 * reqData:
		 * { 	store_number:"@", 
		 * 		promotion_name:"@",
		 * 		promotion_contents:"@" 
		 * },
		 *  reqCode:"@" 
		 *  } responseData format { 단순등록. }
		 */
		
		/*Store testStore = storeFactory.makeStoreEntity(9999,"준범헤어");
		this.storeRepository.save(testStore);
		testStore.setPromotion(storeFactory.makePromotion("haircut", "hello"));
		this.storeRepository.save(testStore);
		Store store=this.storeRepository.findOne(testStore.getStore_number());
		Assert.assertEquals("haircut",store.getPromotion().getPromotion_name());
		Assert.assertEquals("hello",store.getPromotion().getPromotion_contents());*/
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void promoionGetListStore(){
		/**
		 * requestData format
			{
				reqData:{
					store_number:"@"
				},
				reqCode:"@"
			}
			responseData format
			{
				resData:[
					promotion:{
						promotion_name:"@",
						promotion_contents:"@"
					}
				]
				resCode:"@"
			}
		 */
		
		Store testStore=storeFactory.makeStoreEntity(9998,"준범헤어");
		this.storeRepository.save(testStore);
		testStore.setPromotion(storeFactory.makePromotion("getlist", "getlist"));
		this.storeRepository.save(testStore);
		
		Store store=this.storeRepository.findOne((long)9998);
		Promotion promotion=store.getPromotion();
		Assert.assertEquals("getlist", promotion.getPromotion_contents());
		Assert.assertEquals("getlist", promotion.getPromotion_name());
	}
}
