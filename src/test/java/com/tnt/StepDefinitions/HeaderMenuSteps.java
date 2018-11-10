package com.tnt.StepDefinitions;

import com.tnt.Pages.PageBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Random;

public class HeaderMenuSteps {
    PageBase pgBase = new PageBase();

    @Given("^User click on Contact button$")
    public void userClickOnContactButton() throws Throwable {
        pgBase.clickContactButton();
    }

    @Then("^Users sees National Contact number$")
    public void usersSeesNationalContactNumber() throws Throwable {
        pgBase.isNationalNumberDisplayed();
    }

    @And("^User sees International Contact number$")
    public void userSeesInternationalContactNumber() throws Throwable {
        pgBase.isInterNationalNumberDisplayed();
    }

    @Given("^User clicks Inloggen$")
    public void userClickInloggen() throws Throwable {
        pgBase.clickInloggen();
    }

    @When("^User enters unregistered email address \"([^\"]*)\"$")
    public void userEntersUnregisteredEmailAddress(String email) throws Throwable {
        pgBase.enterUserName(email);
    }

    @And("^User enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) throws Throwable {
        pgBase.enterPassword(password);
    }

    @And("^User submit login button$")
    public void userSubmitLoginButton() throws Throwable {
        pgBase.submitInloggen();
    }


    @When("^User click Kies Uw Services option$")
    public void userClickKiesUwServicesOption() throws Throwable {
        pgBase.clickKiesUwServicesButton();
    }

    @Then("^User sees all three services$")
    public void userSeesAllThreeServices() throws Throwable {
        pgBase.areAllServicesDisplayed();
    }

    @Given("^User clicks Account aanmaken$")
    public void userClicksAccountAanmaken() throws Throwable {
        pgBase.clickAccountAanmakenButton();
    }

    @Then("^error message is shown$")
    public void errorMessageIsShown() throws Throwable {
        pgBase.isErrorMessageDisplayed();
    }

    @When("^User selects default country and click next$")
    public void userSelectsDefaultCountryAndClickNext() throws Throwable {
        pgBase.clickVolgendeButton();
    }

    @And("^User enters a valid email address$")
    public void userEntersAValidEmailAddres() throws Throwable {
        Random rand = new Random();
        String randomEmail = "test@tnt" + rand.nextInt() + ".com";
            pgBase.enterUserName(randomEmail);
    }

    @And("^User click next button$")
    public void userClickNextButton() throws Throwable {
        pgBase.clickVolgendeButton();
    }

    @And("^User enters a valid password$")
    public void userEntersAValidPassword() throws Throwable {
        String password = "Test@tnt";
        pgBase.enterPassword(password);
    }

    @And("^Accept privacy policy$")
    public void acceptPrivacyPolicy() throws Throwable {
        pgBase.selectPolicy();
    }

    @Given("^User navigate to the country icon$")
    public void userNavigateToTheCountryIcon() throws Throwable {
        pgBase.navigateToCountry();
    }

    @When("^User search for another country \"([^\"]*)\"$")
    public void userSearchForAnotherCountry(String enterCountry) throws Throwable {
        pgBase.enterCountryToBeSearched(enterCountry);
    }

    @Then("^User see the searched country \"([^\"]*)\" in search result$")
    public void userSeeTheSearchedCountryInSearchResult(String country) throws Throwable {
        pgBase.countryListHasSearchedCountry(country);
    }

    @Then("^Email sent message is shown$")
    public void emailSentMessageIsShown() throws Throwable {
       pgBase.emailSentMessageIsDisplayed();
    }
}
