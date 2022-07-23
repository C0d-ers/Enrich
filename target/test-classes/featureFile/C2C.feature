Feature: Perform Card to Card Transaction
  @CardToCard
  Scenario: User will be able to send money to other people
    When User successfully adds Contact to perform Transaction
    Then User logsIn to the App
    And Goes to CardToCard Trasaction Page
    When user Enters amount and PhoneNumber
    Then User will be redirected to enter OTP
    And Finally to Successful Page
    Then Signs Out from the App