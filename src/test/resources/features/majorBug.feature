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

  @bug_1713
  @severity=critical
  Scenario Outline: Bad redirection
    Given  Go to the page <incident>
    And    Enter the <reference> and <password>
    When   Click on "Envoyer"
    And    Scroll down to the buttom of the page and click on one of the buttom "Quitter sans modifications"
    Then   Display of a blank page

    Examples:
      | incident                      | reference         | password        |
      | https://incident.sagemcom.com/| 2021-52804330-Inc | lQzPoSvT2Ga7xFk |
