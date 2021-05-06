package com.hotelmanagement.utils;

import java.util.Calendar;
import java.util.Date;

public class MyUtil {

	public static Integer getDayOfWeek(Date  date) { 
		//date.setTime(date.getTime() - (2*24*3600)*1000);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
}
