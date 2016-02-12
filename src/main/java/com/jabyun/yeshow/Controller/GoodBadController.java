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
public class GoodBadController extends YeshowController {
	
	@Autowired
	@Qualifier("GoodGetNumService")
	private YeshowService goodGetNumService;
	
	@Autowired
	@Qualifier("BadGetNumService")
	private YeshowService badGetNumService;
	
	@Autowired
	@Qualifier("BadAddService")
	private YeshowService badAddService;
	
	@Autowired
	@Qualifier("GoodAddService")
	private YeshowService goodAddService;
	
	@RequestMapping(value = "/GoodBad/GetGoodNum", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> GetGoodNum (@RequestBody JSONObject requestData, HttpSession session) {
		/*
		 * requestData format Store GetList: reqCode=GB0001
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 	 },
		 *   reqCode:"GB0001" 
		 * }
		 */
		return this.execute(requestData, goodGetNumService, "GB0001");
		
		/**
		 * responseData format Store GetList: resCode=ST0002
		 * { 
		 * 	reqData:[
		 *		good_number:"@",
		 *	]
		 * 	reqCode:"GB0001" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/GoodBad/GetBadNum", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> GetBadNum(@RequestBody JSONObject requestData, HttpSession session) {
		/*
		 * requestData format Store GetList: reqCode=GB0002
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 	 },
		 *   reqCode:"GB0002" 
		 * }
		 */
		return this.execute(requestData, badGetNumService, "GB0002");
		
		/**
		 * responseData format Store GetList: resCode=GB0002
		 * { 
		 * 	reqData:[
		 *		good_number:"@",
		 *	]
		 * 	reqCode:"GB0002" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/GoodBad/AddGood", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> AddGood(@RequestBody JSONObject requestData, HttpSession session) {
		/*
		 * requestData format Store GetList: reqCode=GB0003
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 		tokenID:"@"
		 * 	 },
		 *   reqCode:"GB0003" 
		 * }
		 */
		return this.execute(requestData, goodAddService, "GB0003");
		
		/**
		 * responseData format Store GetList: resCode=GB0003
		 * { 
		 * 	reqData:[
		 *		[Good]
		 *	]
		 * 	reqCode:"GB0003" 
		 * }
		 */
	}
	
	@RequestMapping(value = "/GoodBad/AddBad", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> AddBad(@RequestBody JSONObject requestData, HttpSession session) {
		/*
		 * requestData format Store GetList: reqCode=GB0004
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 		tokenID:"@"
		 * 	 },
		 *   reqCode:"GB0004" 
		 * }
		 */
		return this.execute(requestData, badAddService, "GB0004");
		
		/**
		 * responseData format Store GetList: resCode=GB0004
		 * { 
		 * 	reqData:[
		 *		[Bad]
		 *	]
		 * 	reqCode:"GB0004" 
		 * }
		 */
	}
}