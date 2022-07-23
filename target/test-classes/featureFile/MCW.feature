Feature: Perform MCW
  @MultiCurrency
  Scenario: User will be able to buy and sell Foreign Currency
    When User logs In to the App
    Then User navigates to Currency
    And Selects Desired currency to buy
    Then User will be able to Enter the Amount to buy
    When Transaction becomes successful
    Then User will be redirected to MCW page
