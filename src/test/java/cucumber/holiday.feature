@BookHotelAndFight
  Feature: Going on Holiday
           I want to book flight and hotel

  @BookHotel
  @Scenario: I want to book hotel
    Given I live in Moscow
    And I want to go on a holiday
    And We are 10 Adults
    And We want to book from 2021 to 2022
    When I go to travel Agent
    Then he should be able to book in budget od $10000
    And He should provide option to cancel
    But He should not ask for advance
