package com.jabyun.yeshow.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import freemarker.ext.beans.OverloadedMethodsModel;


public class Calender {
	private static Calendar calendar;
	
	public static long getFirstDayOfthisMonth(){
		calendar = getCalendarForNow();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        setTimeToBeginningOfDay(calendar);
        return calendar.getTimeInMillis();
	}
	
	public static long getNowDate(){
		calendar = getCalendarForNow();
		return calendar.getTimeInMillis();
	}
	
	public static long getFirstDayOfMonth(int year, int month){
		calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date(year-1900,month,1));
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        setTimeToBeginningOfDay(calendar);
        return calendar.getTimeInMillis();
	}
	public static long getDate(int year,int month,int day){
		calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date(year-1900,month,day));
	    return calendar.getTimeInMillis();
	}
	public static long getLastDayOfMonth(int year, int month){
		calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date(year-1900,month,1));
        calendar.set(month,
        		calendar.getActualMaximum(month));
        setTimeToBeginningOfDay(calendar);
        return calendar.getTimeInMillis();
	}
	
	public static long getLastDayOfMonth(){
		calendar = getCalendarForNow();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        setTimeToBeginningOfDay(calendar);
        return calendar.getTimeInMillis();
	}
	public static Calendar getCalendarForNow() {
		new Date();
	    calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date());
	    return calendar;
	}

	private static void setTimeToBeginningOfDay(Calendar calendar) {
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	}

	private static void setTimeToEndofDay(Calendar calendar) {
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	}

}
