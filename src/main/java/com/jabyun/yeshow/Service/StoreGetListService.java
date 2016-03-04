package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.StoreDefaultImage;
import com.jabyun.yeshow.Repository.StoreImageRepository;
import com.jabyun.yeshow.Repository.StoreRepository;

@Component("StoreGetListService")
public class StoreGetListService extends YeshowService{
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreImageRepository storeImageRepository;


	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		//List<Object> store=this.storeRepository.findAllStoreAndImage();
		List<Store> storeList=this.storeRepository.findAll();
		
		for (int i=0; i<storeList.size();i++) {

			Store store=storeList.get(i);
			String storeImage=StoreDefaultImage.getImage(store.getStore_image());
			store.setImage(storeImage);
			//store.setStore_image(storeImage);
			listFinalData.add(store);
        }
		
		return listFinalData;
	}
}
