package de.westwingnow.config;

public class StaticConfig {

    public static final String BROWSER = System.getProperty("browser", "chrome");
    public static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "true"));
    public static final long WAIT_IN_MILLIS = 10000;
}
