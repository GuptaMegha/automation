@Tnt @e2e @HomePage
Feature: Checking feature of Home Page

  @test_login
  Scenario: As a user I want to login to myTNT account
    Given User clicks Inloggen
    When User enters unregistered email address "test@tntTest.nl"
    And User enters password "password"
    And User submit login button
    Then error message is shown

  @test_accountAanmaken
  Scenario: As a user I want to create myTNT account
    Given User clicks Account aanmaken
    When User selects default country and click next
    And User enters a valid email address
    And User click next button
    And Accept privacy policy
    And User enters a valid password
    And User click next button
    Then Email sent message is shown

  @test_contact
  Scenario: As a user I want to contact TNT
    When User click on Contact button
    Then Users sees National Contact number
    And User sees International Contact number

  @test_services
  Scenario: As a user I want to check TNT services
    When User click Kies Uw Services option
    Then User sees all three services

  @test_geo
  Scenario: As a user I am able to select another country
    Given User navigate to the country icon
    When User search for another country "India"
    Then User see the searched country "India" in search result