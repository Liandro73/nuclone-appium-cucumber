#language:en

  @Regressive
  Feature: Balance

    @Smoke @Balance
    Scenario Outline: Scenario:  Check the balance
      Given I am on the dashboard
      When I click on Show Balance button
      Then I should see in the balance the value "<value>"

      Examples:
        | value       |
        | R$ 5.500,00 |