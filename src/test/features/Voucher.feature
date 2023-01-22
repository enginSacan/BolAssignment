@Voucher
Feature: Users should have voucher ın dıfferent options for other and themselves

  Background: Opening home page
    Given User opens web page

  Scenario Outline: User wants to add to the card
    When User <action> voucher in the card
    Then Voucher should be <expected_result> in the card
  Examples:
    | action | expected_result |
    | add    | added           |
    | remove | removed         |
