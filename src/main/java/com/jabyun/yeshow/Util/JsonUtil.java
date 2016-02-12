package com.jabyun.yeshow.Util;

import org.aspectj.lang.annotation.Aspect;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	public JsonUtil(){}
	
	public JSONObject parseJSON(String reqStrData) throws RuntimeException {
		
		JSONObject joPrsingData = null;
		joPrsingData = (JSONObject) JSONValue.parse(reqStrData);
		if(joPrsingData==null) throw new RuntimeException("올바른 JSON 데이터 형식이 아닙니다.");
		if(joPrsingData.containsKey("reqData")==false) throw new RuntimeException("요청 데이터가 없습니다.");
		
		//strSvcCd = (String) joPrsingData.get("_req_svc");
		
		logger.debug(joPrsingData.get("reqData").toString());
		
		return (JSONObject) joPrsingData.get("reqData");
	}
}
