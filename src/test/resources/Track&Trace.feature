@Tnt @e2e @Track&trace
Feature: Checking feature Track and Trace

  Scenario: As a user I want to be notified when I Track and Trace for wrong shipment number
    Given User enters a shipment number 123456789
    And User submit the zoeken button
    Then User sees the track visit
    And shipment number 123456789 is not found