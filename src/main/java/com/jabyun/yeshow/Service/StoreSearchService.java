package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("StoreSearchService")
public class StoreSearchService extends YeshowService{

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		
		/**
		 * requestData format { 
		 * reqData:
		 * { 	store_query:"@"
		 * },
		 *  reqCode:"@" 
		 *  } responseData 
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		List<Store> storeList = this.storeRepository.findAll();
		String storeQuery=(String)dataObject.get("store_query");
		for (Store store : storeList) {
			if(store.getStore_name().matches(storeQuery)||store.getDistrict().matches(storeQuery)||store.getStoreDetail().getStore_phone().matches(storeQuery)){
				listFinalData.add(store);
			}
		}
		
		return listFinalData;
	}

}
