package com.tnt.StepDefinitions;

import com.tnt.Util.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook{

    @Before
    public void beforeScenario(){
        Driver.startdriver();
    }

    @After
    public void afterScenario(){
        Driver.driver.close();

    }
}
