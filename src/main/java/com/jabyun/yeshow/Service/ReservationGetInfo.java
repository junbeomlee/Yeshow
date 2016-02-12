package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Reservation;
import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.ReservationRepository;
import com.jabyun.yeshow.Repository.ServerRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("ReservationGetInfo")
public class ReservationGetInfo extends YeshowService{
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	ServerRepository serverRepository;
	

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		
		// store_number
		// server_number
		// reservtion date 2016-12-12
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = null;
		try {
			parsed = format.parse((String)dataObject.get("reservation_date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        
		Store store = storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		Server server = serverRepository.findOne(StringToLong.convert(dataObject.get("server_number")));
		
		List<Reservation> reservationlist = reservationRepository.findByStoreAndUserInTime(store,server,sqlDate);
		
		for (Reservation reservation : reservationlist) {
			listFinalData.add(reservation);
		}
		return listFinalData;
	}
}
