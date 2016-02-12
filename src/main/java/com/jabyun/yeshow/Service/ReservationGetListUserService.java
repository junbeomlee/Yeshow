package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Reservation;
import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.ReservationRepository;
import com.jabyun.yeshow.Repository.ServerRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;


@Component("ReservationGetListUserService")
public class ReservationGetListUserService extends YeshowService{
	
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ServerRepository serverRepository;
	

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		
		// store_number
		ArrayList<Object> listFinalData = new ArrayList<Object>();

		User user=userRepository.findOne(StringToLong.convert(dataObject.get("tokenID")));
		
		List<Reservation> reservationList=reservationRepository.findByUser(user);
	
		for(int i=0;i<reservationList.size();i++){
			listFinalData.add(reservationList.get(i));
		}
		
		return listFinalData;
	}

}


