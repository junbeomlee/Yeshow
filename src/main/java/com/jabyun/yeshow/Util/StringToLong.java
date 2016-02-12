package com.jabyun.yeshow.Util;

public class StringToLong {
	public static long convert(Object object){
		
		return Long.parseLong((String)object);
	}
	
	public static long convert(String string){
		
		return Long.parseLong(string);
	}
}
