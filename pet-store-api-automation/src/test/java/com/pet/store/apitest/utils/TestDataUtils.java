package com.pet.store.apitest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataUtils {

    private static final String PET_NAME = "pet.name";
    private static final String PET_STORE_ID = "petstore.dog.id";
    private static final String UPDATE_PET_STORE_ID = "update.petstore.dog.id";
    private static final String CATEGORY_NAME ="categoryName";


    private static Properties properties;

    public static void load() {
        properties = new Properties();

        try (InputStream inputStream = TestDataUtils.class.getClassLoader().getResourceAsStream(ConfigUtils.getTestdataFile())) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + ConfigUtils.getTestdataFile());
        }
    }

    public static boolean isLoaded() {
        return properties != null;
    }

    public static Integer postPetStoreid() {
        return Integer.valueOf(properties.getProperty(PET_STORE_ID));
    }

    public static String petname() {
        return properties.getProperty(PET_NAME);
    }
    public static String categoryName() {
        return properties.getProperty(CATEGORY_NAME);
    }
    public static String updatepetid(){
        return properties.getProperty(UPDATE_PET_STORE_ID);
    }

}