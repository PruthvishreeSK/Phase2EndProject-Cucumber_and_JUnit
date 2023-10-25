Feature: Automation test for star health page using cucumber

  Scenario: Validate the Star Health Buy Now flow
    Given User launches the Star Health application
    Then User validates the Star Health home page title using a JUnit assertion
    When User clicks on the Buy Now button
    Then User types following details
      | Name         | PhNo       | PIN    |
      | Pruthvishree | 9999999999 | 577101 |
    And User clicks on I need health insurance from the drop-down menu and selects My Family
    And User validates that the mobile number is the same as the previously entered number using a JUnit assertion
    When User clicks on the Star Health logo
   
