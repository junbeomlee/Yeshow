package com.jabyun.yeshow.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.apache.lucene.store.StoreRateLimiting;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.ServerRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.StringToLong;

@Component("ServerSignUpService")
public class ServerSignUpService extends YeshowService{

	@Autowired
	private ServerRepository serverRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException,SQLDataException {
		// TODO Auto-generated method stub
		/**
		 * dataObject
		 * 	long server_number
		 *  int store_number
		 *  server_name
		 *  server_offtime
		 *  store_number
		 *  server_age
		 */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		int store_number=Integer.parseInt((String)dataObject.get("store_number"));
		Store store= storeRepository.findOne((long) store_number);
		
		
		if(store!=null){
			String server_number =(String) dataObject.get("server_number");
			String server_name = (String) dataObject.get("server_name");
			String server_phone = (String) dataObject.get("server_phone");
			String server_offtime = (String) dataObject.get("server_offtime");
			String server_age = (String) dataObject.get("server_age");
			Server server = new Server(StringToLong.convert(server_number),store,server_name,server_offtime,server_phone,"",Integer.valueOf(server_age));
			server=this.serverRepository.save(server);
			listFinalData.add(server);
		}else{
			throw new SQLDataException("no matching store_number");
		}
		
		return listFinalData;
	}

}
