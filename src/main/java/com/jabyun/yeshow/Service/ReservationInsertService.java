package com.jabyun.yeshow.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
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
import com.jabyun.yeshow.Util.Calender;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("ReservationInsertService")
public class ReservationInsertService extends YeshowService {

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
		// tokenID
		// server_number
		/**
		 * date:{
	         year:"@"
	         month:"@"
	         day:"@"
	      }
	      time:{
	         hour:"@"
	         min:"@"
	      }
		 * */
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		User user=userRepository.findOne(StringToLong.convert(dataObject.get("tokenID")));
		Store store=storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
		Server server=serverRepository.findOne(StringToLong.convert(dataObject.get("server_number")));
		JSONObject reservationDate=(JSONObject) dataObject.get("date");
		JSONObject reservationTime=(JSONObject) dataObject.get("time");
		Reservation reservation=new Reservation();
		Time time = new Time(Integer.parseInt((String) reservationTime.get("hour")), Integer.parseInt((String)reservationTime.get("min")), 0);
		Date date= new Date(Calender.getDate(Integer.parseInt((String) reservationDate.get("year")), Integer.parseInt((String) reservationDate.get("month")), Integer.parseInt((String) reservationDate.get("day"))));
		reservation=reservation.makeReservation(user, store, server,date,time,(String)dataObject.get("reservation_etc"));
		
		reservationRepository.save(reservation);
		listFinalData.add(reservation);
		
		return listFinalData;
	}

}
