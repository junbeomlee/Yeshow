package com.jabyun.yeshow.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;

public class ResponseData {
	public static Map<String, Object> buildResponseData(ArrayList<Object> resultListData,String resCode) throws JsonParseException{
		
		Map<String,Object> mapFinalRslt= new HashMap<String,Object>();
		mapFinalRslt.put("resCode", resCode);
		mapFinalRslt.put("resData", resultListData);
		
		return mapFinalRslt;
	}
}
