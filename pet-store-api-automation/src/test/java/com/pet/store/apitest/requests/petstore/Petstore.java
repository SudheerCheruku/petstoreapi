package com.pet.store.apitest.requests.petstore;

import com.pet.store.apitest.utils.ConfigUtils;
import com.pet.store.apitest.utils.TestDataUtils;
import io.restassured.response.Response;

import static com.pet.store.apitest.constants.ServiceUrlConstants.LOGIN_PET_SERVICE_URL;
import static com.pet.store.apitest.constants.ServiceUrlConstants.GET_PET_SERVICE_URL;
import static com.pet.store.apitest.constants.ServiceUrlConstants.PUT_PET_SERVICE_URL;
import static com.pet.store.apitest.constants.ServiceUrlConstants.DELETE_PET_SERVICE_URL;
import static io.restassured.RestAssured.given;

public class Petstore{

    public Response postPetStore(){
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .body("{\n" +
                        "  \"id\": \""+TestDataUtils.postPetStoreid()+"\",\n" +
                        "  \"name\": \""+TestDataUtils.petname()+"\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Dogs\"\n" +
                        "  },\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
        .post(ConfigUtils.getBaseURL().concat(LOGIN_PET_SERVICE_URL));
    }

    public Response VerifyPetIdCreated(Integer petId) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("petId", petId)
                .log().all()
                .get(ConfigUtils.getBaseURL().concat(GET_PET_SERVICE_URL));
    }

    public Response putPetDetails(int petId) {
        return given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": \""+petId+"\",\n" +
                        "  \"name\": \"doggies\",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"NewDogs\"\n" +
                        "  },\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .log().all()
                .put(ConfigUtils.getBaseURL().concat(PUT_PET_SERVICE_URL));

    }
    public Response deletePetDetails(Integer petId){
        return given()
                .header("Content-Type", "application/json")
                .log().all()
                .pathParam("petId", petId)
                .delete(ConfigUtils.getBaseURL().concat(DELETE_PET_SERVICE_URL));


    }
    }

