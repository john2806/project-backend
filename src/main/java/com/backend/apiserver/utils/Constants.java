package com.backend.apiserver.utils;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Constants {

    /**
     * Role user
     */
    public static final String ROLE_USER = "ROLE_USER";

    /**
     * Role mentor
     */
    public static final String ROLE_MENTOR = "ROLE_MENTOR";

    /**
     * Role admin
     */
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * CLAIM_ID
     */
    public static final String CLAIM_ID = "id";

    /**
     * BANKCARD
     */
    public static final int BANK_CARD = 1;

    /**
     * EWALLET
     */
    public static final int E_WALLET = 2;

    /**
     * Using ISOString for default date format
     */
    public static DateTimeFormatter ISO_8601 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /**
     * Using ISOString for default date format with gmt +7
     */
    public static DateTimeFormatter BEGINNING_INDOCHINA_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'00:00:00.000+07");

    public static String INDOCHINA_ZONE = "Asia/Saigon";
}
