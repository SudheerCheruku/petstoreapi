package com.pet.store.apitest.service;

import com.pet.store.apitest.context.ScenarioContext;
import com.pet.store.apitest.context.TestContext;
import com.pet.store.apitest.utils.ConfigUtils;
import com.pet.store.apitest.utils.TestDataUtils;


public class AbstractSteps {

    private TestContext testContext;
    private ScenarioContext scenarioContext;

    public void beforeEachScenario() {
        testContext = TestContext.getTestContext();
        scenarioContext = testContext.getScenarioContext();

        if (!ConfigUtils.isLoaded()) {
            ConfigUtils.load();
        }

        if (!TestDataUtils.isLoaded()) {
            TestDataUtils.load();
        }
    }

    public void afterEachScenario(){
        testContext.reset();
    }

    public TestContext getTestContext() {
        return testContext;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}