package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.GoodRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("GoodGetNumService")
public class GoodGetNumService extends YeshowService{
	
	@Autowired
	private GoodRepository goodRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		/*
		 * requestData format Store GetList: reqCode=ST0002
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 	 },
		 *   reqCode:"ST0002" 
		 * }
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		Store store = storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		List<Good> goodList=goodRepository.findByStore(store);
		
		for (Good good : goodList) {
			listFinalData.add(good);
		}
		return listFinalData;
	}

}
