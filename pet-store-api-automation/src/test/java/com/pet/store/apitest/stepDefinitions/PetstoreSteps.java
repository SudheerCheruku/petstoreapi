package com.pet.store.apitest.stepDefinitions;

import com.pet.store.apitest.requests.petstore.Petstore;
import com.pet.store.apitest.service.AbstractSteps;
import com.pet.store.apitest.utils.TestDataRecord;
import com.pet.store.apitest.utils.TestDataUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;


import static com.pet.store.apitest.constants.ScenarioKeys.*;
import static org.hamcrest.CoreMatchers.*;

public class PetstoreSteps extends AbstractSteps {

    private Petstore petstore;
    private TestDataRecord testDataRecord;

    public PetstoreSteps() {
        petstore = new Petstore();
        testDataRecord = new TestDataRecord();
    }

    @Before
    public void beforeEachScenario() {
        super.beforeEachScenario();
    }

    @Given("^create Post request to add a new pet to the store$")
    public void createANewPostRequestAddANewPetToTheStore() {
        Response response = petstore.postPetStore();
        Integer petId = response.jsonPath().get("id");
        response
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("id", equalTo(TestDataUtils.postPetStoreid()))
                .body("name", equalTo(TestDataUtils.petname()));

        getScenarioContext().set(PET_ID, petId);
        getScenarioContext().setResponse(response);

    }

    @When("^pet was created verify the data$")
    public void thenVerifyThePetWasCreatedWithCorrectData() {
        int petId = getScenarioContext().getInteger(PET_ID);
        Response response = petstore.VerifyPetIdCreated(petId);
        response
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("id", equalTo(petId));

        getScenarioContext().setResponse(response);
    }

    @And("^they can update the pet information using the PUT request and verify the updated information in response$")
    public void theyCanUpdateThePetInformataionUsingThePUTRequestAndVerifyTheUpdatedInformationInResposne() {
        int petId = getScenarioContext().getInteger(PET_ID);
        Response response = petstore.putPetDetails(petId);
        response.then()
                .statusCode(200)
                .log().all()
                .body("id", equalTo(petId));
    }


    @Then("^can delete the pet using DELETE request and verify the pet is deleted successfully$")
    public void theyCanDeleteThePETUsingDELETERequestAndVerifyThePetIsDeletedSuccessfully() {
        int petId = getScenarioContext().getInteger(PET_ID);
        Response response = petstore.deletePetDetails(petId);
        response
                .then()
                .statusCode(200)
                .log()
                .all();

        getScenarioContext().setResponse(response);
    }


    @After
    public void afterEachScenario() {
        super.afterEachScenario();

    }
}
