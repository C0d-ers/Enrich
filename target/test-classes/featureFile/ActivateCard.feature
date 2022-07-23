Feature: User will be able to activate Card and set a PIN
  @ActivateCard
  Scenario: Card Activation

    When User login to the App
    Then User will navigate to CardSetting
    And Enter Activate Card
    But User should know there CardNumber and Their ID number
    Then User will enter last four digits of there CardNumber and IDNumber
    And Enters the OTP received
    Then User sets the new PIN and again enters OTP
    And Finally user will be redirected to successfully Page