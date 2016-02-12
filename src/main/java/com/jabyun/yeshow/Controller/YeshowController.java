package com.jabyun.yeshow.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.jabyun.yeshow.Service.YeshowService;
import com.jabyun.yeshow.Util.DuplicateException;
import com.jabyun.yeshow.Util.ErrorHandler;
import com.jabyun.yeshow.Util.JsonUtil;
import com.jabyun.yeshow.Util.RequestCheck;
import com.jabyun.yeshow.Util.ResponseData;

@Component
public abstract class YeshowController {
	
	@Autowired
	protected Facebook facebook;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	
	
	public Map<String,Object> execute(JSONObject requestData,YeshowService yeshowService, String reqCode){
		
		Map<String,Object> mapFinalRslt = new HashMap<String, Object>();
		ArrayList<Object> listFinalData = null;
		JSONObject reqDataObject = null;
		
		try{
			if(RequestCheck.isVaild(requestData)){
				reqDataObject=this.jsonUtil.parseJSON(requestData.toJSONString());
			}
			listFinalData = yeshowService.execute(reqDataObject);
			mapFinalRslt=ResponseData.buildResponseData(listFinalData, reqCode);
		}catch(DuplicateException e){
			mapFinalRslt=ErrorHandler.makeErrorMsg(mapFinalRslt,ErrorHandler.DuplicateExceptionError,e.getMessage());
			e.printStackTrace(System.out);
		}catch(JsonParseException e){
			mapFinalRslt=ErrorHandler.makeErrorMsg(mapFinalRslt,ErrorHandler.JsonParseError,e.getMessage());
		}catch(SQLException e){
			mapFinalRslt=ErrorHandler.makeErrorMsg(mapFinalRslt,ErrorHandler.SQLExceptionError,e.getMessage());
			e.printStackTrace(System.out);
		}catch(RuntimeException e){
			mapFinalRslt=ErrorHandler.makeErrorMsg(mapFinalRslt,ErrorHandler.RuntimeError,e.getMessage());
			e.printStackTrace(System.out);
		}finally{
		
		}
		
		return mapFinalRslt;
	}
}