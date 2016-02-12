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
public class ReservationController extends YeshowController{
	
	@Autowired
	@Qualifier("ReservationInsertService")
	private YeshowService reservationInsertService;
	
	@Autowired
	@Qualifier("ReservationGetListStoreService")
	private YeshowService reservationGetListStoreService;
	
	@Autowired
	@Qualifier("ReservationGetListUserService")
	private YeshowService reservationGetListUserService;
	
	@Autowired
	@Qualifier("ReservationDeleteService")
	private YeshowService reservationDeleteService;
	
	@Autowired
	@Qualifier("ReservationCompleteService")
	private YeshowService ReservationCompleteService;
	
	@RequestMapping(value = "/Reservation/Insert",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ReservationInsert(@RequestBody JSONObject requestData, HttpSession session){
		
		
		/*
		 * requestData format Store GetList: reqCode=RV0001
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 		tokenID:"@",
		 * 		server_number:"@"
		 * 	 },
		 *   reqCode:"RV0001" 
		 * }
		 */
		return this.execute(requestData, reservationInsertService, "RV0001");
		
		/**
		 * responseData format Store GetList: resCode=RV0001
		 * { 
		 * 	resData:[
		 *		Reservation:[]
		 *	]
		 * 	resCode:"RV0001" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/Reservation/GetList/Store",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ReservationGetListStore(@RequestBody JSONObject requestData, HttpSession session){
		
		
		/*
		 * requestData format Store GetList: reqCode=RV0002
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 		reservation_data:"@",
		 * 	 },
		 *   reqCode:"RV0002" 
		 * }
		 */
		return this.execute(requestData, reservationGetListStoreService, "RV0002");
		
		/**
		 * responseData format Store GetList: resCode=RV0002
		 * { 
		 * 	resData:[
		 *		Reservation:[],
		 *		Reservation:[],
		 *			...
		 *	]
		 * 	resCode:"RV0002" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/Reservation/GetList/User",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ReservationGetListUser(@RequestBody JSONObject requestData, HttpSession session){
		
		
		/*
		 * requestData format Store GetList: reqCode=RV0003
		 * { 
		 * 	 reqData:{
		 * 		tokenID:"@",
		 * 	 },
		 *   reqCode:"RV0003" 
		 * }
		 */
		return this.execute(requestData, reservationGetListUserService, "RV0003");
		
		/**
		 * responseData format Store GetList: resCode=RV0003
		 * { 
		 * 	resData:[
		 *		Reservation:[],
		 *		Reservation:[],
		 *			...
		 *	]
		 * 	resCode:"RV0002" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/Reservation/Delete",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ReservationDelete(@RequestBody JSONObject requestData, HttpSession session){
		
		
		/*
		 * requestData format Store GetList: reqCode=RV0004
		 * { 
		 * 	 reqData:{
		 * 		reservation_number:"@",
		 * 	 },
		 *   reqCode:"RV0004" 
		 * }
		 */
		return this.execute(requestData, reservationDeleteService, "RV0004");
		
		/**
		 * responseData format Store GetList: resCode=RV0004
		 * { 
		 * 	resData:[
		 *		"success"
		 *	]
		 * 	resCode:"RV0004" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/Reservation/Complete",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ReservationComplete(@RequestBody JSONObject requestData, HttpSession session){
		
		
		/*
		 * requestData format Store GetList: reqCode=RV0005
		 * { 
		 * 	 reqData:{
		 * 		reservation_number:"@",
		 * 	 },
		 *   reqCode:"RV0005" 
		 * }
		 */
		return this.execute(requestData, ReservationCompleteService, "RV0005");
		
		/**
		 * responseData format Store GetList: resCode=RV0005
		 * { 
		 * 	resData:[
		 *		Reservation:[]
		 *	]
		 * 	resCode:"RV0005" 
		 * }
		 */
	}
}
