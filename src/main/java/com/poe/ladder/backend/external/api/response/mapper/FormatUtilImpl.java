package com.poe.ladder.backend.external.api.response.mapper;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class FormatUtilImpl implements FormatUtil {

    private DecimalFormat formatter = new DecimalFormat("#,###");

    public String formatNumber(String number) {
        String numberAsString = number.replaceAll(",", "");
        Double numberAsDouble = Double.parseDouble(numberAsString);
        return formatter.format(numberAsDouble);
    }

}
