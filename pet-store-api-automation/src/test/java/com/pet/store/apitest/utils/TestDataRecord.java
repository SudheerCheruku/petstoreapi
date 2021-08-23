package com.pet.store.apitest.utils;

import io.restassured.response.Response;

import java.util.HashMap;

public class TestDataRecord {

    private static HashMap<String, Integer> testDataRecord;
    private Response response;

    public TestDataRecord() {
        testDataRecord= new HashMap<>();
        response= null;
    }

}
