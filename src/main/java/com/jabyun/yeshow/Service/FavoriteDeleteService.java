package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Favorite;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.FavoriteRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("FavoriteDeleteService")
public class FavoriteDeleteService extends YeshowService{
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		
		/*
		 * requestData format User Login: reqCode=FV0003
		 * {
		 * 	reqData:{
		 * 		tokenID:"@",
		 * 		store_number:"@"
		 * 	},
		 *  reqCode:"FV0003"
		 * }
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		Store store = storeRepository.findOne(Long.parseLong((String)dataObject.get("store_number")));
		User user= userRepository.findOne(Long.parseLong((String)dataObject.get("tokenID")));
		
		Favorite favorite=(Favorite)favoriteRepository.findByTokenIDAndStoreNumber(user.getTokenID(),store.getStore_number());
		if(favorite!=null){
			favoriteRepository.delete(favorite);
		}else{ 
			// delete안된다.
			throw new DuplicateException("duplicate Favorite List");
		}
		
		listFinalData.add(favorite);
	
		return listFinalData;
	}
}
