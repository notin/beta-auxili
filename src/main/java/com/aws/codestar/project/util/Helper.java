package com.aws.codestar.project.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Logger;

public class Helper
{

    static Logger logger = Logger.getAnonymousLogger();

    public static String getUUID() {
        return String.valueOf(UUID.randomUUID());
    }

    public static String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }


}
