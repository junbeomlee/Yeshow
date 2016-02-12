package com.jabyun.yeshow.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabyun.yeshow.Service.YeshowService;

@Controller
public class HistoryController extends YeshowController{
	
	@Autowired
	@Qualifier("HistoryGetListUserService")
	private YeshowService HistoryGetListUserService;
	
	@Autowired
	@Qualifier("HistoryGetListByThisMonthService")
	private YeshowService HistoryGetListByThisMonthService;
	
	@Autowired
	@Qualifier("HistoryGetListByMonthService")
	private YeshowService HistoryGetListByMonthService;
	
	@Autowired
	@Qualifier("HistoryGetListStoreService")
	private YeshowService HistoryGetListStoreService;
	
	@Autowired
	@Qualifier("HistorySearchService")
	private YeshowService HistorySearchService;
	
	
	
	@RequestMapping(value = "/History/GetList/User",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> HistoryGetListUser(@RequestBody JSONObject requestData, HttpSession session){
		/**
		 * requestData format resCode=HS0001 
		 * { 
		 * 	reqData:{
		 * 		tokenID:"@"
		 *  }
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
		
		return this.execute(requestData,HistoryGetListUserService,"HS0001");
		
		/**
		 * responseData format resCode=HS0001 
		 * { 
		 * 	reqData:[
		 * 		History:[],
		 * 		History:[],
		 * 			...
		 *  ]
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/History/GetListByThisMonth",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> HistoryGetListByThisMonth(@RequestBody JSONObject requestData, HttpSession session){
		/**
		 * requestData format resCode=HS0002 
		 * { 
		 * 	reqData:{
		 * 		store_number:"@"
		 *  }
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
		
		return this.execute(requestData,this.HistoryGetListByThisMonthService,"HS0002");
		
		/**
		 * responseData format resCode=HS0002
		 * { 
		 * 	reqData:[
		 * 		History:[],
		 * 		History:[],
		 * 			...
		 *  ]
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/History/GetListByMonth",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> HistoryGetListByMonth(@RequestBody JSONObject requestData, HttpSession session){
		/**
		 * requestData format resCode=HS0003
		 * { 
		 * 	reqData:{
		 * 
		 * 		store_number:"@",
		 * 		month:"@", //->int 값 january면 0
		 * 		year:"@", //->2016년 ,2015년 등등
		 *  }
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
		
		return this.execute(requestData,this.HistoryGetListByMonthService,"HS0003");
		
		/**
		 * responseData format resCode=HS0003
		 * { 
		 * 	reqData:[
		 * 		History:[],
		 * 		History:[],
		 * 			...
		 *  ]
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/History/GetList/Store",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> HistoryGetListStore(@RequestBody JSONObject requestData, HttpSession session){
		/**
		 * requestData format resCode=HS0004
		 * { 
		 * 	reqData:{
		 * 		store_number:"@"
		 *  }
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
		return this.execute(requestData,HistoryGetListStoreService,"HS0004");
		
		/**
		 * responseData format resCode=HS0004
		 * { 
		 * 	reqData:[
		 * 		History:[],
		 * 		History:[],
		 * 			...
		 *  ]
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/History/Search",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> HistorySearch(@RequestBody JSONObject requestData, HttpSession session){
		/**
		 * requestData format resCode=HS0005
		 * { 
		 * 	reqData:{
		 * 		store_number:"@",
		 * 		query:"@"
		 *  }
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
		return this.execute(requestData,HistorySearchService,"HS0005");
		
		/**
		 * responseData format resCode=HS0005
		 * { 
		 * 	reqData:[
		 * 		History:[],
		 * 		History:[],
		 * 			...
		 *  ]
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
}
