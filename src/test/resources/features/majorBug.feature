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

  @bug_1739
  @severity=critical
  Scenario: Inadequate redirection
    Given  Go to Sagemcom homepage
    When   Click on "smart city"
    And    Click on "Acceptez tout" located on top at the right side
    Then   Display of the homepage in a new tab

  @bug_1742
  @severity=critical
  Scenario Outline: Non functional button
    Given  Go to the page <solution-multi-energies>
    When   Scroll down to the section "Decouvrez nos différentes solutions de comptage"
    And    Click on one of the <button>
    Then   No reaction

    Examples:
      |button      | solution-multi-energies                                                            |
      |le_gaz      | https://www.sagemcom.com/fr/le-comptage-intelligent-de-leau/solution-multi-energies|
      |lelectricite| https://www.sagemcom.com/fr/le-comptage-intelligent-de-leau/solution-multi-energies|


  @bug_1754
  @severity=critical
  Scenario Outline: Loop link
    Given Go to the page <plan-de-site>
    When  Click on "Autres"
    Then  the site plan reload

    Examples:
      |plan-de-site                        |
      |https://sagemcom.com/fr/plan-de-site|

  @bug_1760
  @severity=blocker
  Scenario Outline: Unable to complete the second password reset step
    Given Go to the homepage
    And   Click on "Accéder au PIM2"
    When  Click on "Mot de passe oublié?"
    And   Enter the <identifiant> and click on "suivant"
    And   Click on the unroll list "Choisir une question secrète"
    Then  The list does not run

    Examples:
      |identifiant           |
      |scom.hapi@sagemcom.com|
