@Tnt @e2e @Tarieven&Tijden
  Feature: Checking feature Tarieven and Tijden

    @test_envelope
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

    @test_doos
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

    @test_pallet
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

    @test_noform
    Scenario: As a user If I want to be notified for adding location
      Given User clicks on location
      When User submit the request quote
      Then error message for location is shown