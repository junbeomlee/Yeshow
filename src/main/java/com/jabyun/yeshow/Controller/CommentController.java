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
public class CommentController extends YeshowController {
	
	@Autowired
	@Qualifier("CommentGetListStoreSerivce")
	private YeshowService CommentGetListStoreSerivce;
	
	@Autowired
	@Qualifier("CommentInsertService")
	private YeshowService CommentInsertSerivce;
	
	@RequestMapping(value = "/Comment/GetList/Store",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> CommentGetList(@RequestBody JSONObject requestData, HttpSession session){
		
		/*
		 * requestData format  reqCode=CM0001
		 * {
		 * 	reqData:{
		 * 		store_number:"@",
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, CommentGetListStoreSerivce, "CM0001");
		/**
		 * responseData format resCode=CM0001
		 * {
		 * 	reqData:[
		 * 		Comment:[],
		 * 		Comment:[],
		 * 		...
		 * 
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/Comment/Insert",  produces="application/json; charset=utf8")
	public @ResponseBody Map<String, Object> CommentInsert(@RequestBody JSONObject requestData, HttpSession session){
		
		/*
		 * requestData format  reqCode=CM0002
		 * {
		 * 	reqData:{
		 * 		store_number:"@",
		 * 		token_id:"@",
		 * 		contents:"@",
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, CommentInsertSerivce, "CM0002");
		/**
		 * responseData format resCode=CM0001
		 * {
		 * 	reqData:[
		 * 		Comment:[],
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
	}
}
