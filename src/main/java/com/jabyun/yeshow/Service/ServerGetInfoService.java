package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Repository.HistoryRepository;
import com.jabyun.yeshow.Repository.ServerRepository;

@Component("ServerGetInfoService")
public class ServerGetInfoService extends YeshowService{
	
	@Autowired
	private ServerRepository serverRepository;
	
	@Autowired
	private HistoryRepository historyRepository;

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * dataObject
		 * 	long server_number
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		Server server = serverRepository.findOne(Long.parseLong((String)dataObject.get("server_number")));
		
		List<History> historyList=historyRepository.findByServer(server);
		listFinalData.add(server);
		for(int i=0;i<historyList.size();i++){
			listFinalData.add(historyList.get(i));
		}
		return listFinalData;
	}

}
