package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.HistoryRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.StringToLong;

@Component("HistorySearchService")
public class HistorySearchService extends YeshowService{

		@Autowired
		private HistoryRepository historyRepository;
		
		@Autowired
		private StoreRepository storeRepository;

		
		@Transactional
		@Override
		public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
			// TODO Auto-generated method stub
			
			/**
			 * store_number
			 * query
			 */
			ArrayList<Object> listFinalData = new ArrayList<Object>();
			Store store=storeRepository.findOne(StringToLong.convert(dataObject.get("store_number")));
			List<History> historyList=this.historyRepository.findByStore(store);

			for (History history : historyList) {
				if(history.getReservation_etc().matches((String)dataObject.get("query"))){
					listFinalData.add(history);
				}
			}
			
			return listFinalData;
		}

	}

