package com.scerutti.shared;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomLogger {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    static {
        ConsoleHandler handler = new  ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);

        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.ALL);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
