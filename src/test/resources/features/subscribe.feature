Feature: Training subscription

  Background:
    Given the visitor opens the home page
    And the home page is displayed
    And the user navigates to the Training page

  Scenario Outline: Subscribe to training updates
    When the user opens the subscription form
    And the user accepts cookies
    And the user fills the subscription form with first name "<firstName>", last name "<lastName>", and email "<email>"
    And the user selects the first country
    And the user selects the first skill
    And the user submits the subscription form
    Then the subscription success popup should be displayed

    Examples:
      | firstName | lastName | email |
      | name     | lastname    | email@example.com |