Feature: Create token
  Description: authentication token creation

  @ScenarioCreateTokenSuccessful
  Scenario: Create token successful
    Given The user generate a token of authorization
    When The user send request to endpoint
    Then The API should return the access token with status 200