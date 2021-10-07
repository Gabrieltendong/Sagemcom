Feature: Major or Critical bug

  @bug_1769
  @severity=critical
  Scenario: 404 error
    Given Go to Sagemcom homepage
    When  Click on "smart city"
    And   Click on the logo Sagemcom in the navigation bar
    Then  Redirection to an 404 error page