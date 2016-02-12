package com.jabyun.yeshow.Util;

import org.json.simple.JSONObject;

public class RequestCheck {
	
	public RequestCheck(){}
	
	public static boolean isVaild(JSONObject requestData){
		
		if(requestData.toJSONString()==null || "".equals(requestData.toJSONString())) {
			throw new RuntimeException("요청 데이터가 없습니다.");
		} else {
			return true;
		}
	}
}
