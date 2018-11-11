@Tnt @e2e @Tarieven&Tijden
  Feature: TNT E2E test scenarios

    Scenario: As a user I want to get a quote for an envelope
      Given User enters From address "Amsterdam"
      And User enters To address "Berlin"
      And User selects "Enveloppe" as shipment type
      When User submit the request quote
      Then User sees if quote widget title is shown
      When User selects "Goederen (geen documenten)" as envelope type
      And User Enters Envelope weight 1 kg
      And User request for quote
      Then quotes are visible


    Scenario: As a user I want to get a quote for a Doos
      Given User enters From address "Amsterdam"
      And User enters To address "Berlin"
      And User selects "Doos" as shipment type
      When User submit the request quote
      Then User sees if quote widget title is shown
      When User enters following package details
         |length | breadth | height | weight |
         |10     | 10      | 10     | 10     |
      And User request for quote
      Then quotes are visible

    Scenario: As a user I want to get a quote for a Pallet
      Given User enters From address "Amsterdam"
      And User enters To address "Berlin"
      And User selects "Pallet" as shipment type
      When User submit the request quote
      Then User sees if quote widget title is shown
      When User enters following package details
        |length | breadth | height | weight |
        |10     | 10      | 10     | 10     |
      And User request for quote
      Then quotes are visible

      Scenario: As a user I want to be notified when I Track and Trace for wrong shipment number
        Given User enters a shipment number 123456789
        And User submit the zoeken button
        Then User sees the track visit
        And shipment number 123456789 is not found

      Scenario: As a user I want to contact TNT
        When User click on Contact button
        Then Users sees National Contact number
        And User sees International Contact number

      Scenario: As a user I want to check TNT services
        When User click Kies Uw Services option
        Then User sees all three services

      Scenario: As a user I want to login to myTNT account
        Given User clicks Inloggen
        When User enters unregistered email address "test@tntTest.nl"
        And User enters password "password"
        And User submit login button
        Then error message is shown

      Scenario: As a user I want to create myTNT account
        Given User clicks Account aanmaken
        When User selects default country and click next
        And User enters a valid email address
        And User click next button
        And Accept privacy policy
        And User enters a valid password
        And User click next button
        Then Email sent message is shown

        Scenario: As a user If I want to be notified for adding location
          Given User clicks on location
          When User submit the request quote
          Then error message for location is shown

        Scenario: As a user I am able to select another country
          Given User navigate to the country icon
          When User search for another country "India"
          Then User see the searched country "India" in search result


