package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Repository.HistoryRepository;
import com.jabyun.yeshow.Util.DuplicateException;


@Component("HistoryGetListUserService")
public class HistoryGetListUserService extends YeshowService{

	@Autowired
	private HistoryRepository historyRepository;

	/***
	 * @param
	 * 	tokenID
	 */
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		List<History> history=this.historyRepository.findAllByTokenID(Long.parseLong((String)dataObject.get("tokenID")));

		for (int i=0; i<history.size();i++) {
	
			History temp=history.get(i);
			listFinalData.add(temp);
        }
		
		return listFinalData;
	}

}
