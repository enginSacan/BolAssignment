@Return
Feature: We have a return policy for our clients but there are some restrictions.
  * User needs to login to create return order

  Background: Opening home page
    Given User opens web page

  Scenario Outline: User wants to return product without login
    When User starts the <processes> process
    Then User should redirected to login page
    Examples:
      | processes |
      | return    |
      | warranty  |