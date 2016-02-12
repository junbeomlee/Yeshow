package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Repository.FavoriteRepository;
import com.jabyun.yeshow.Repository.UserRepository;

@Component("FavoriteGetListService")
public class FavoriteGetListService extends YeshowService 
{
	
	@Autowired
	private FavoriteRepository favoriteRepository;	


	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		
		// TODO Auto-generated method stub
		long tokenID=Long.parseLong((String)dataObject.get("tokenID"));
		
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		List<Object> favoriteList=this.favoriteRepository.findAllByTokenId(tokenID);
		for(int i=0;i<favoriteList.size();i++){
			listFinalData.add(favoriteList.get(i));
		}
		
		return listFinalData;
	}
	
}
