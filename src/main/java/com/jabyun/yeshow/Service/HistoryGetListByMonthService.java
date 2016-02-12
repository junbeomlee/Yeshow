package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Repository.HistoryRepository;
import com.jabyun.yeshow.Util.Calender;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("HistoryGetListByMonthService")
public class HistoryGetListByMonthService extends YeshowService{

	@Autowired
	private HistoryRepository historyRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		
		//store_number
		//month
		int month=Integer.parseInt((String)dataObject.get("month").toString());
		int year=Integer.parseInt((String)dataObject.get("year"));
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		java.sql.Date sqlDateStartMonth = new java.sql.Date (Calender.getFirstDayOfMonth(year,month));
		java.sql.Date sqlDateEndMonth = new java.sql.Date (Calender.getFirstDayOfMonth(year,month+1));
		System.out.println(sqlDateStartMonth.toString());
		System.out.println(sqlDateEndMonth.toString());
		int historyListNumber=historyRepository.findAllByMonth(sqlDateStartMonth,sqlDateEndMonth,Long.parseLong((String)dataObject.get("store_number")));
		
		listFinalData.add(historyListNumber);
        
		return listFinalData;
	}

}
