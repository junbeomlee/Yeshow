package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Bad;
import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.GoodRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("GoodAddService")
public class GoodAddService  extends YeshowService{
	
	@Autowired
	private GoodRepository goodRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		/**
		 * tokenID
		 * store_number
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		User user= this.userRepository.findOne(StringToLong.convert(dataObject.get("tokenID")));
		Store store = this.storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		
		Good good=new Good(user,store);
		
		List<Good> goodList=this.goodRepository.findByStoreAndUser(store,user);
		if(goodList.isEmpty()){
			this.goodRepository.save(good);
			listFinalData.add(good);
		}else{
			listFinalData.add("duplicated good");
		}
		
		
		listFinalData.add(good);
		
		
		return listFinalData;
	}

}


