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
public class ServerController extends YeshowController{
	
	@Autowired
	@Qualifier("ServerSignUpService")
	private YeshowService ServerSignUpService;
	
	@Autowired
	@Qualifier("ServerDeleteService")
	private YeshowService serverDeleteService;
	
	@Autowired
	@Qualifier("ServerGetListService")
	private YeshowService serverGetListService;
	
	@Autowired
	@Qualifier("ServerGetInfoService")
	private YeshowService serverGetInfoService;

	@RequestMapping(value = "/Server/SignUp", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ServerSignUp(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 *  int store_number
		 *  server_name
		 *  server_offtime
		 * requestData format User Login: reqCode=SR0001
		 * {
		 * 	reqData:{
		 * 		store_number:"@",
		 * 		server_name:"@",
		 * 		server_offtime:"@",
		 * 		server_phone:"@"
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, ServerSignUpService, "SR0001");
		/**
		 * responseData format User Login: resCode=SR0001
		 * {
		 * 	reqData:[
		 * 		Server:[]
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
		
	}
	
	@RequestMapping(value = "/Server/Delete", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ServerDelete(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format User Login: reqCode=SR0002
		 * {
		 * 	reqData:{
		 * 		server_number:"@"
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, serverDeleteService, "SR0002");
		/**
		 * responseData format User Login: resCode=SR0002
		 * {
		 * 	reqData:[
		 * 		Server:[],
		 * 
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
		
	}
	
	@RequestMapping(value = "/Server/GetList", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ServerGetList(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format User Login: reqCode=SR0003
		 * {
		 * 	reqData:{
		 * 		store_number:"@"
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, serverGetListService, "SR0003");
		/**
		 * responseData format User Login: resCode=SR0003
		 * {
		 * 	reqData:[
		 * 		Server:[],
		 * 		Server:[],
		 * 		Server:[],
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
		
	}
	
	@RequestMapping(value = "/Server/GetInfo", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> ServerGetInfo(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format User Login: reqCode=SR0004
		 * {
		 * 	reqData:{
		 * 		server_number:"@"
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, serverGetInfoService, "SR0004");
		/**
		 * responseData format User Login: resCode=SR0004
		 * {
		 * 	reqData:[
		 * 		Server:[],
		 * 		History:[],
		 * 		History:[],
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
		
	}
}
