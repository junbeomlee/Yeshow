package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Bad;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.BadRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("BadGetNumService")
public class BadGetNumService extends YeshowService{
	
	@Autowired
	private BadRepository badRepository;
	
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
		List<Bad> BadList=badRepository.findByStore(store);
		
		for (Bad bad : BadList) {
			listFinalData.add(bad);
		}
		return listFinalData;
	}

}

