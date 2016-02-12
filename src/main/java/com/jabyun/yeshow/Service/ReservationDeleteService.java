package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Repository.ReservationRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("ReservationDeleteService")
public class ReservationDeleteService extends YeshowService{
	
	@Autowired
	ReservationRepository reservationRepository;
	

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		
		// reservation_number
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		reservationRepository.delete(StringToLong.convert(dataObject.get("reservation_number")));
		listFinalData.add("success");
		return listFinalData;
	}
}
