package com.tnt.StepDefinitions;

import com.tnt.Pages.Components.TrackAndTraceComponent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TrackAndTraceSteps {
    TrackAndTraceComponent trackC = new TrackAndTraceComponent();

    @Given("^User enters a shipment number (\\d+)$")
    public void userEntersANumber(int shipmentNumber) throws Throwable {
        trackC.setShipmentNumber(shipmentNumber);
    }

    @And("^User submit the zoeken button$")
    public void userSubmitTheZoekenButton() throws Throwable {
        trackC.submitZoekenButton();
    }

    @Then("^User sees the track visit$")
    public void userSeesTheFollowShipment() throws Throwable {
        trackC.trackVisitIsVisible();
    }

    @And("^shipment number (\\d+) is not found$")
    public void shipmentNumberIsNotFound(int shipmentNumber) throws Throwable {
        trackC.trackFeedback(shipmentNumber);
    }
}
