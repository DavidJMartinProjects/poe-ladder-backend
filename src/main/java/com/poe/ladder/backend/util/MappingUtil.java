package com.poe.ladder.backend.util;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

@Component
public class MappingUtil {

    private static DecimalFormat formatter = new DecimalFormat("#,###");

    public static String formatStringToDouble(String number) {
        String numberAsString = number.replaceAll(",", "");
        Double numberAsDouble = Double.parseDouble(numberAsString);
        return formatter.format(numberAsDouble);
    }
    
    public static String removeCommasFromXpValue(String xpValue) {
		return xpValue.replaceAll(",", "");
	}
	
    public static String formatXpDifference(String xpDifference) {
		Double xpDifferenceAsDouble = Double.parseDouble(xpDifference);
		return String.format("%.2fM", xpDifferenceAsDouble/ 1000000.0);		
	}
    
    public static String formatRank(String rankDifference) {
		Long difference = Long.parseLong(rankDifference);
		if(difference > 0) {
			return "+" + difference;
		}
		return rankDifference;
	}
    
}	
	