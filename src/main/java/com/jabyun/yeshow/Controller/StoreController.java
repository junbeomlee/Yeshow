package com.jabyun.yeshow.Controller;

import java.sql.SQLException;
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
public class StoreController extends YeshowController{

	@Autowired
	@Qualifier("StoreGetListService")
	private YeshowService storeGetListService;
	
	
	@Autowired
	@Qualifier("StoreGetInfoService")
	private YeshowService storeGetInfoService;
	
	@Autowired
	@Qualifier("StorePromotionAddService")
	private YeshowService storePromotionAddService;
	
	
	@Autowired
	@Qualifier("StoreSearchService")
	private YeshowService storeSearchService;
	

	/**
	 * 
	 * @param requestData
	 * @param session
	 * @return String
	 * 
	 *         reqCode=ST0001
	 */
	@RequestMapping(value = "/Store/GetList", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> StoreGetList(@RequestBody JSONObject requestData, HttpSession session) throws SQLException {
		/*
		 * requestData format Store GetList: reqCode=ST0001
		 * { 
		 * 	 reqData:[],
		 *   reqCode:"ST0001" 
		 * }
		 */
		return this.execute(requestData, storeGetListService, "ST0001");
		/**
		 * responseData format Store GetList: resCode=ST0001 
		 * { reqData:[
		 *  Store1: [{
		 *  	imageInfo: ,
		 *  	storeInfo:[],
		 *  }] 
		 *  Store2: [{
		 *  	imageInfo: ,
		 *  	storeInfo:[],
		 *  }],
		 *		.....
		 * ], 
		 * 
		 * reqCode:"ST0001" }
		 */
	}

	/**
	 * 
	 * @param requestData
	 * @param session
	 * @return String
	 * 
	 *         reqCode=ST0002
	 */
	

	@RequestMapping(value = "/Store/GetInfo", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String, Object> StoreGetInfo(@RequestBody JSONObject requestData, HttpSession session) {
		/**
		 * requestData format Store GetInfo: reqCode=ST0003
			{
				reqData:{
					store_number:"@"
				},
				reqCode:"ST0003"
			}*/
		

		return this.execute(requestData, storeGetInfoService, "ST0003");
		
		/*
		responseData format
		{
			resData:[
				[store]
			]
			resCode:"ST0003"
		}
	 */
	}
	
	@RequestMapping(value = "/Store/PromotionAdd", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String, Object> StorePromotionAdd(@RequestBody JSONObject requestData, HttpSession session) {
		/**
		 * requestData format Store PromotionAdd: reqCode=ST0004
			{
				reqData:{
					store_number:"@",
					promotion_name:"@",
		 * 			promotion_contents:"@" 
				},
				reqCode:"ST0004"
			}*/
		

		return this.execute(requestData, storePromotionAddService, "ST0004");
		
		/*
		responseData format
		{
			resData:[
				
				[promotion]
			]
			resCode:"ST0004"
		}
	 */
	}
	
	@RequestMapping(value = "/Store/Search", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String, Object> StoreSearch(@RequestBody JSONObject requestData, HttpSession session) {
		/**
		 * requestData format Store PromotionAdd: reqCode=ST0005
			{
				reqData:{
					store_query:"@",
				},
				reqCode:"ST0005"
			}*/
		

		return this.execute(requestData, this.storeSearchService, "ST0005");
		
		/*
		responseData format
		{
			resData:[
				
				[store]
				[store]
				...
			]
			resCode:"ST0005"
		}
	 */
	}
}
