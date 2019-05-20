package com.poe.ladder.backend.external.api.response.mapper;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

@Component
public class FormatUtilImpl implements FormatUtil {

    private DecimalFormat formatter = new DecimalFormat("#,###");

    public String formatStringToDouble(String number) {
        String numberAsString = number.replaceAll(",", "");
        Double numberAsDouble = Double.parseDouble(numberAsString);
        return formatter.format(numberAsDouble);
    }
	
}
