package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Bad;
import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.BadRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("BadAddService")
public class BadAddService extends YeshowService{
	
	@Autowired
	private BadRepository badRepository;
	
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
		
		Bad bad=new Bad(user,store);
		List<Bad> badList=this.badRepository.findByStoreAndUser(store,user);
		if(badList.isEmpty()){
			this.badRepository.save(bad);
			listFinalData.add(bad);
		}else{
			listFinalData.add("duplicated bad");
		}
		
		return listFinalData;
	}

}


