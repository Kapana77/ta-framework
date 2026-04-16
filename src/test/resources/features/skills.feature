Feature: Skills search

  Background:
    Given the user opens the home page
    And the home page is loaded
    And the user navigates to the Skills page

  Scenario Outline: Search and open a skill card
    When the user searches for skill "<skill>"
    Then the skill card "<skill>" should be displayed
    When the user opens the skill card "<skill>"
    Then the opened skill page url should contain "<skillUrlPart>"

    Examples:
      | skill | skillUrlPart |
      | .NET  | NET          |