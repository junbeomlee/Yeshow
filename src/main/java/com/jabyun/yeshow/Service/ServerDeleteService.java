package com.jabyun.yeshow.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.ServerRepository;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("ServerDeleteService")
public class ServerDeleteService extends YeshowService{
	
	@Autowired
	private ServerRepository serverRepository;

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		/**
		 * dataObject
		 * 	long server_number
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		serverRepository.delete(Long.parseLong((String)dataObject.get("server_number")));
		
		listFinalData.add("success");
		
		return listFinalData;
	}

}
