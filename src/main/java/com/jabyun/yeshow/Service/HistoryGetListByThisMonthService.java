package com.jabyun.yeshow.Service;

import java.sql.Date;
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

@Component("HistoryGetListByThisMonthService")
public class HistoryGetListByThisMonthService extends YeshowService{

	@Autowired
	private HistoryRepository historyRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		// store_number
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		//String firstDayOfMonthString=Calender.getFirstDayOfMonth();
		//java.util.Date today=new Date();
		//today.getTime();
		java.sql.Date sqlDate = new java.sql.Date (Calender.getFirstDayOfthisMonth());
		//java.sql.Date sqlDate2 = new java.sql.Date (Calender.getFirstDayOfMonth(3));
		System.out.println(sqlDate.toString());
		List<History> historyList=historyRepository.findAllByMonth(sqlDate,Long.parseLong((String)dataObject.get("store_number")));
		
		for(int i=0;i<historyList.size();i++){
			listFinalData.add(historyList.get(i));
		}
        
		return listFinalData;
	}

}
