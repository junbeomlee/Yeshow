package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Domain.Reservation;
import com.jabyun.yeshow.Repository.HistoryRepository;
import com.jabyun.yeshow.Repository.ReservationRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("ReservationCompleteService")
public class ReservationCompleteService extends YeshowService{
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	HistoryRepository HistoryRepository;
	

	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		
		// reservation_number
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		Reservation reservation = reservationRepository.findOne(StringToLong.convert(dataObject.get("reservation_number")));
		reservationRepository.delete(reservation);
		History history= new History(reservation);
		HistoryRepository.save(history);
		listFinalData.add(history);
		
		return listFinalData;
	}
}
