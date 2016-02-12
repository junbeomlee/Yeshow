package com.jabyun.yeshow.Util;

import java.util.ArrayList;
import java.util.Map;

public class ErrorHandler {

	public static final int JsonParseError = 9999;
	public static final int RuntimeError = 9998;
	public static final int ExceptionError = 9997;
	public static final int SQLExceptionError = 9996;
	public static final int DuplicateExceptionError =9995;
	
	public static Map<String,Object> makeErrorMsg(Map<String, Object> mapFinalRslt, int jsonParseError, String string){
		mapFinalRslt.put("resData", string);
		mapFinalRslt.put("resCode",jsonParseError);
		
		return mapFinalRslt;
	}
	
}
