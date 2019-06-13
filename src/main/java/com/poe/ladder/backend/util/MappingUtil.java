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
    
}	
	