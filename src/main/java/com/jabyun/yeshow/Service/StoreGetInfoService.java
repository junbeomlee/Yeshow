package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("StoreGetInfoService")
public class StoreGetInfoService extends YeshowService{

	@Autowired
	private StoreRepository storeRepository;
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		
		/**
		 * store_number:"@"
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		Store store=this.storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		
		listFinalData.add(store);
		
		return listFinalData;
	}

}
