package com.bluep.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalLogger {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void logInfo(String msg) {
        LOGGER.log(Level.INFO, msg);
    }
}
