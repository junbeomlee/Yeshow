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


public class FavoriteController extends YeshowController {
	
	@Autowired
	@Qualifier("FavoriteGetListService")
	private YeshowService favoriteGetListService;
	
	@Autowired
	@Qualifier("FavoriteInsertService")
	private YeshowService favoriteInsertService;
	
	@Autowired
	@Qualifier("FavoriteDeleteService")
	private YeshowService favoriteDeleteService;

	@RequestMapping(value = "/Favorite/GetList", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> FavoriteGetList(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format  reqCode=FV0001
		 * {
		 * 	reqData:{
		 * 		tokenID:"@"
		 * 	},
		 *  reqCode:"@"
		 * }
		 */
		return this.execute(requestData, favoriteGetListService, "FV0001");
		/**
		 * responseData format resCode=FV0001
		 * {
		 * 	reqData:[
		 * 		Favorite:[],
		 * 		Favorite:[],
		 * 		...
		 * 
		 * 	],
		 *  reqCode:"@"
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/Favorite/Insert", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> FavoriteInsert(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format reqCode=FV0002
		 * {
		 * 	reqData:{
		 * 		tokenID:"@",
		 * 		store_number:"@"
		 * 	},
		 *  reqCode:"FV0002"
		 * }
		 */
		//YeshowService yeshowService = new FavoriteInsert();
		return this.execute(requestData, favoriteInsertService, "FV0002");
		/**
		 * responseData format resCode=FV0002
		 * {
		 * 	reqData:[
		 * 		Favorite:[]
		 * 	],
		 *  reqCode:"FV0002"
		 * }
		 * 
		 */
	}
	
	@RequestMapping(value = "/Favorite/Delete", produces="application/json; charset=utf8")
	public @ResponseBody Map<String,Object> FavoriteDelete(@RequestBody JSONObject requestData, HttpSession session){
		/*
		 * requestData format reqCode=FV0003
		 * {
		 * 	reqData:{
		 * 		tokenID:"@",
		 * 		store_number:"@"
		 * 	},
		 *  reqCode:"FV0003"
		 * }
		 */
		//YeshowService yeshowService = new FavoriteInsert();
		return this.execute(requestData, favoriteDeleteService, "FV0003");
		/**
		 * responseData format resCode=FV0002
		 * {
		 * 	reqData:[
		 * 		Favorite:[]
		 * 	],
		 *  reqCode:"FV0003"
		 * }
		 * 
		 */
	}
}
