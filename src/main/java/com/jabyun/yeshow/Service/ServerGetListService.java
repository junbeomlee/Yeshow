package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.ServerRepository;
import com.jabyun.yeshow.Repository.StoreRepository;


@Component("ServerGetListService")
public class ServerGetListService extends YeshowService{
	
	@Autowired
	private ServerRepository serverRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * dataObject
		 * 	long store_number
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		Store store=storeRepository.findOne(Long.parseLong((String)dataObject.get("store_number")));
		List<Server> serverList=serverRepository.findByStore(store);
		
		for(int i=0;i<serverList.size();i++){
			listFinalData.add(serverList.get(i));
		}
		return listFinalData;
	}

}