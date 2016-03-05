package com.jabyun.yeshow.test.service;

import java.sql.SQLException;
import java.util.ArrayList;

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
import com.jabyun.yeshow.Service.ReservationGetListStoreService;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.test.util.InstanceTestClassListener;
import com.jabyun.yeshow.test.util.InstanceTestClassRunner;

@RunWith(InstanceTestClassRunner.class)
@SpringApplicationConfiguration(classes = Springboot2Application.class)
@WebAppConfiguration
@Component
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class TestReservationGetListStoreService implements InstanceTestClassListener {

	@Autowired private ReservationGetListStoreService reservationGetListStoreService;
	@Override
	public void beforeClassSetup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClassSetup() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void reservationGetListStoreService(){
		/*
		JSONObject dataObject= new JSONObject();
		dataObject.put("year", "2016");
		dataObject.put("month", "1");
		dataObject.put("day", "1");
		dataObject.put("store_number", "10011");
		
		ArrayList<Object> listFinalData = null;
		try {
			listFinalData = reservationGetListStoreService.execute(dataObject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(2, listFinalData.size());*/
	}

	
}
