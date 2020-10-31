package com.backend.apiserver.utils;

import java.text.DecimalFormat;

public class FormatUtils {

    public static String percentageFormatter(Float floatNumber) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##%");
        return decimalFormat.format(floatNumber);
    }
}
