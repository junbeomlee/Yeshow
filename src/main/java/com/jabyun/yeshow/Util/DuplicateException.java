package com.jabyun.yeshow.Util;

public class DuplicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1997753363232807009L;

	public DuplicateException()
	
	        {
	
	        }

	public DuplicateException(String message)
	
	        {
	
	            super(message);
	
	        }

	public DuplicateException(Throwable cause)
	
	        {
	
	            super(cause);
	
	        }

	public DuplicateException(String message, Throwable cause)
	        {
	
	            super(message, cause);
	
	        }

	public DuplicateException(String message, Throwable cause,
	
	                                           boolean enableSuppression, boolean writableStackTrace)
	
	        {
	
	            super(message, cause, enableSuppression, writableStackTrace);
	
	        }

}
