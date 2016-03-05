package com.jabyun.yeshow.test;

import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jabyun.yeshow.Springboot2Application;
import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.BadRepository;
import com.jabyun.yeshow.Repository.GoodRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Service.StoreGetListService;
import com.jabyun.yeshow.test.factory.GoodFactory;
import com.jabyun.yeshow.test.factory.StoreFactory;
import com.jabyun.yeshow.test.factory.UserFactory;
import com.jabyun.yeshow.test.util.InstanceTestClassListener;
import com.jabyun.yeshow.test.util.InstanceTestClassRunner;
import com.jabyun.yeshow.test.util.ObserverCollector;

@RunWith(InstanceTestClassRunner.class)
@SpringApplicationConfiguration(classes = Springboot2Application.class)
@WebAppConfiguration
@Component
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class GoodBadTests implements InstanceTestClassListener{

	@Autowired private GoodRepository goodRepository;
	@Autowired private BadRepository badRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private StoreRepository storeRepository;
	
	@Autowired private GoodFactory goodFactory;
	@Autowired private StoreFactory storeFactory;
	@Autowired private UserFactory userFactory;
	@Autowired private ObserverCollector observerCollector;
	
	@Autowired private StoreGetListService storeGetListService;
	
	
	@Override
	public void beforeClassSetup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClassSetup() {
		// TODO Auto-generated method stub
		//observerCollector.clearAll();
	}
	
	@Test
	public void GoodAddTest(){
		
		/*final long userNum=9999;
		final long storeNum=9998;
		
		User user=userFactory.makeUserEntity(9999, "이준범");
		this.userRepository.save(user);
		Store store=storeFactory.makeStoreEntity(storeNum, "준범헤어");
		this.storeRepository.save(store);
		Good expectedGood = goodFactory.makeGoodEntity(user, store);
		this.goodRepository.save(expectedGood);
		Good actualGood = goodRepository.findOne(expectedGood.getGood_number());
		Assert.assertSame(expectedGood.getGood_number(),actualGood.getGood_number());*/
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void BadAddTest(){
		/*JSONObject dataObject= new JSONObject();
		dataObject.put("reqCode", "ST0001");
		JSONObject reqData = new JSONObject();
		reqData.put("store_number", "10011");
		dataObject.put("reqData",reqData);
		try {
			storeGetListService.execute(dataObject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
