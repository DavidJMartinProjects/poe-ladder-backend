package com.poe.ladder.backend.application;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtil {
	
	public static String getCurrentTimestamp() {
		Date date = new Date();
		Timestamp ts=new Timestamp(date.getTime());  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return formatter.format(ts);
	}

}
	