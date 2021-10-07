Feature: Major or Critical bug

  @bug_1769
  @severity=critical
  Scenario: 404 error
    Given Go to Sagemcom homepage
    When  Click on "smart city"
    And   Click on the logo Sagemcom in the navigation bar
    Then  Redirection to an 404 error page

  @bug_1707
  @severity=critical
  Scenario Outline: Non-functional search functionality
    Given Go to the page <incident>
    And   Click on the search icon in the navigation bar
    When  Enter <search_term> in the field "search" and validate
    Then  Display of an error page 404 with the title "Not found"

    Examples:
      |incident                      | search_term  |
      |https://incident.sagemcom.com/| harcèlement  |