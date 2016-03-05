package com.jabyun.yeshow.Controller;

import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController extends YeshowController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/api/login")
	public @ResponseBody String apiLogin() {
		int a=0;
		return Paths.get("").toAbsolutePath().toString();
		
	}
	
	@RequestMapping(value = "/admin/hello")
	public String admin() {
		
		return "admin";
		
	}
	
	@RequestMapping(value = "/needLogin.do", produces = "application/json; charset=utf8")
	public @ResponseBody String GetGoodNum (@RequestBody JSONObject requestData, HttpSession session) {
		/*
		 * requestData format Store GetList: reqCode=GB0001
		 * { 
		 * 	 reqData:{
		 * 		store_number:"@",
		 * 	 },
		 *   reqCode:"GB0001" 
		 * }
		 */
		return requestData.toString();
		
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
}
