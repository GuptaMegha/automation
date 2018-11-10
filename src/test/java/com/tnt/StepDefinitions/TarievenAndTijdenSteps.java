package com.tnt.StepDefinitions;

import com.tnt.Pages.Components.TarievenAndTijdenComponent;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class TarievenAndTijdenSteps {
    TarievenAndTijdenComponent tntC = new TarievenAndTijdenComponent();

    @Given("^User enters From address \"([^\"]*)\"$")
    public void userEntersFromAddress(String inputFromLocation) throws Throwable {
        tntC.setInputFromLocation(inputFromLocation);
    }

    @And("^User enters To address \"([^\"]*)\"$")
    public void userEntersToAddress(String inputToLocation) throws Throwable {
        tntC.setInputToLocation(inputToLocation);
    }

    @And("^User selects \"([^\"]*)\" as shipment type$")
    public void userSelectsEnvelopAsShipmentType(String packageType) throws Throwable {
        tntC.selectPackageType(packageType);
    }

    @When("^User submit the request quote$")
    public void userSubmitTheRequestQuote() throws Throwable {
        tntC.submitRequestQuoteButton();
    }

    @Then("^User sees if quote widget title is shown$")
    public void userIsRedirectedToShipNowPage() throws Throwable {
        tntC.isQuoteWidgetTitleVisible();
    }

    @When("^User enters following package details$")
    public void userEntersFollowingPackageDetails(DataTable packageDetails) throws Throwable {
        List<List<String>> data = packageDetails.raw();
        tntC.inputLength(data.get(1).get(0));
        tntC.inputBreadth(data.get(1).get(1));
        tntC.inputHeigth(data.get(1).get(2));
        tntC.inputweight(data.get(1).get(3));
    }

    @And("^User request for quote$")
    public void userRequestForQuote() throws Throwable {
        tntC.submitGetQuoteButton();
    }

    @Then("^quotes are visible$")
    public void quotesAreVisible() throws Throwable {
        tntC.isQuoteSummaryVisible();
    }

    @When("^User selects \"([^\"]*)\" as envelope type$")
    public void userSelectsAsEnvelopeType(String envelopeType) throws Throwable {
        tntC.selectEnvelopeType(envelopeType);
    }

    @And("^User Enters Envelope weight (\\d+) kg$")
    public void userEntersEnvelopeWeightKg(String weight) throws Throwable {
        tntC.inputweight(weight);
    }

    @Then("^error message for location is shown$")
    public void errorMessageForLocationIsShown() throws Throwable {
        tntC.isNoLocationErrorDisplayed();
    }

    @Given("^User clicks on location$")
    public void userClicksOnLocation() throws Throwable {
        tntC.clickLocation();
    }
}
