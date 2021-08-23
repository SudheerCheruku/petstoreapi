package com.pet.store.apitest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    private static final String CONFIG_PROP_FILE = "config.properties";
    private static final String BASE_URL = "baseUrl";
    private static final String BARCLAYS_SECRET_KEY = "barclays.secretkey";
    private static final String TEST_DATA_FILE = "test.data.file";

    private static Properties properties;

    public static void load() {
        properties = new Properties();

        try (InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream(CONFIG_PROP_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + CONFIG_PROP_FILE);
        }
    }

    public static boolean isLoaded() {
        return properties != null;
    }

    public static String getBaseURL() {
        return properties.getProperty(BASE_URL);
    }

    public static String getBarclaysSecretKey() {return properties.getProperty(BARCLAYS_SECRET_KEY);}

    public static String getTestdataFile() {
        return properties.getProperty(TEST_DATA_FILE);
    }
}