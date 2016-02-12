package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Promotion;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;
import com.jabyun.yeshow.test.factory.StoreFactory;

import junit.framework.Assert;

@Component("StorePromotionAddService")
public class StorePromotionAddService extends YeshowService{

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		
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
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		Store store = this.storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		Promotion promotion = new Promotion();
		promotion.setPromotion_contents((String)dataObject.get("promotion_contents"));
		promotion.setPromotion_name((String)dataObject.get("promotion_name"));
		store.setPromotion(promotion);
		this.storeRepository.save(store);
		
		listFinalData.add(promotion);
		
		return listFinalData;
	}

}
