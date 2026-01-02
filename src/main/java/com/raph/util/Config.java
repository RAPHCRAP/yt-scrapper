package com.raph.util;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (in == null) {
                throw new RuntimeException("application.properties not found");
            }
            props.load(in);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
