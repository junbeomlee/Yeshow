package com.jabyun.yeshow.Controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jabyun.yeshow.Service.YeshowService;

@Controller
public class UserController extends YeshowController {

	//@Autowired
	
	
	@Autowired
	@Qualifier("UserLoginService")
	private YeshowService userLoginService;
	

	@RequestMapping(value = "/User/Login", produces = "application/json; charset=utf8")
	public @ResponseBody Map<String,Object> UserLogin(@RequestBody JSONObject requestData, HttpSession session){


		/*
		 * requestData format User Login: reqCode=LG0001 
		 * {
		 * 	reqData:
		 * 		{tokenID:"@"},
		 * 	reqCode:"@"
		 * }
		 */
		/*System.out.println(facebook.userOperations().getUserProfile().toString());
		if (!facebook.isAuthorized()) {
           System.out.println("facebook 인증 실패");
        }*/
		//System.out.println(this.facebook.isAuthorized());
		return this.execute(requestData,userLoginService,"LG0001");
		
		/**
		 * responseData format User Login: resCode=LG0001 
		 * { 
		 * 	reqData:
		 * 		[ User: ],
		 * 	reqCode:"@" 
		 * }
		 * 
		 */
	}
	@RequestMapping(value = "/User/Logout", produces = "application/json; charset=utf8")
	public @ResponseBody String UserLogout(@RequestBody JSONObject requestData, HttpSession session) {
		
		return "asdzzz";
	}
}
