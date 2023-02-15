package com.bluep.lib;

import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GLogger {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void logInfo(String msg) {
        LOGGER.log(Level.INFO, msg);
    }

    public static void logFormatInfo(String msg, Object... replacements) {
        String msgFormatted = new Formatter().format(msg, replacements).toString();

        GLogger.logInfo(msgFormatted);
    }
}
