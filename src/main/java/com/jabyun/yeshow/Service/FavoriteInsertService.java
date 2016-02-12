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

@Component("FavoriteInsertService")
public class FavoriteInsertService extends YeshowService{
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(storeRepository.toString());
		/*
		 * requestData format User Login: reqCode=FV0002
		 * {
		 * 	reqData:{
		 * 		tokenID:"@",
		 * 		store_number:"@"
		 * 	},
		 *  reqCode:"FV0002"
		 * }
		 */
		
		
		
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		Store store = storeRepository.findOne(Long.parseLong((String)dataObject.get("store_number")));
		User user= userRepository.findOne(Long.parseLong((String)dataObject.get("tokenID")));
		
		Favorite favorite=(Favorite)favoriteRepository.findByTokenIDAndStoreNumber(user.getTokenID(),store.getStore_number());
		if(favorite!=null){ //존재 -> save 안해도됨
			//throw new SQLException("duplicate Favorite exist");
		}else{ 
			// delete안된다.
			favorite = new Favorite();
			favorite.makeFavorite(user, store);
			favoriteRepository.save(favorite);
		}
		//Favorite favorite = new Favorite();
		
		listFinalData.add(favorite);
	
		return listFinalData;
	}

}
