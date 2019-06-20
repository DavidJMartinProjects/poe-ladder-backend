package com.poe.ladder.backend.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimestampUtilTest {
	
	private static final String MMMM_DD_YYYY_HH_MM_SS = "MMMM dd YYYY, HH:mm:ss";
	Logger logger = LoggerFactory.getLogger(TimestampUtilTest.class);
	
	@Test
	public void dateAndTimeFormatTest() {
		logger.info("Formatted date is : {}", getFormattedDate());
	}
	
	public String getFormattedDate() {
		Date date = new Date();
		Timestamp ts=new Timestamp(date.getTime());  
		SimpleDateFormat formatter = new SimpleDateFormat(MMMM_DD_YYYY_HH_MM_SS);  
		return formatter.format(ts);
	}

}
