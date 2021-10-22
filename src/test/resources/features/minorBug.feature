Feature: Minor Bug

  @bug_1661
  @severity=minor
  Scenario Outline: Opening an empty dialogue box
    Given Go to the page <engagements>
    When Click on "Nos certifications"
    And Go back to the tab of the page "Engagements"
    Then Presence of a dialogue box

    Examples:
      | engagements                             |
      | https://www.sagemcom.com/fr/engagements |

  @bug_1666
  @severity=minor
  Scenario: No pointer when hovering over a link in the navigation bar
    Given Go to Sagemcom homepage
    When  Fly over the link "Activitéz"
    Then  The cursor changes to a text selector


  @bug_1710
  @severity=minor
  Scenario Outline: No check on the dates of the incident report form
    Given  Go to the page <incident>
    And    Click on "Déclarer un nouvel incident"
    When   Click on "suivant"
    And    Fill the form and click on "Envoyer"
           | <country> | <first_name>    | <last_name>   | <email> | <phone_number>    | <link> | <description>    | <start_date>    | <end_date>      |
    Then   Display of the dialogue box containing the reference and the password to access at the incident

    Examples:
      |incident                      | country   | first_name    | last_name   | email            | phone_number    | link      | description           | start_date    | end_date      |
      |https://incident.sagemcom.com/| Albania  | Paul           | Alain       | paul@gmail.com   | 0612345678      | Recipient  | some description      | 15-10-2021    | 08-10-2021    |


  @bug_1722
  @severity=minor
  Scenario Outline: Contract type not visisble
    Given Go to the page <carriere>
    When  Clik on "Type de contract" in the filter
    Then  The third checkbox has no text

  Examples:
    |carriere                             |
    |https://www.sagemcom.com/V02/carriere|

  @bug_1727
  @severity=minor
  Scenario Outline: Character encoing problem
    Given Go to the page <carriere>
    When  Scroll down to the footer
    Then  Accented characters are replaced in texts by symbols

  Examples:
    |carriere                             |
    |https://www.sagemcom.com/V02/carriere|

  @bug_1730
  @severity=minor
  Scenario Outline: Equipement image not displayed
    Given Go to the page <controle-vocal>
    When  Click on the right  chevron of the carousel
    Then  No image displayed

  Examples:
    |controle-vocal                                                                                          |
    |https://www.sagemcom.com/fr/solutions-audio-video/software-solutions/controle-vocal-et-assistant-vocaux |

  @bug_1744
  @severity=minor
  Scenario Outline: Duplication amoung decoder / sounds types
    Given Go to the page <support>
    When Scroll down to the section "Recherche par catégorie" and click on "Décodeurs-Son"
    And   Unroll the list "Gamme"
    Then  "Decodeur satellite" displayed twice

  Examples:
    |support                        |
    |https://support.sagemcom.com/fr|

  @bug_1766
  @severity=minor
  Scenario Outline: Translation error
    Given  Go to the homepage
    And    Click on "recevoir vos commandes d'achats et saisir vos confirmations application Portail-2G"
    When   Click on "Nouveau fournisseurs? Se référencer"
    And    Change the <language> page on top right in Italy or in Germany
    Then   Some items of the page are not in the select language

  Examples:
    | language |
    | Allemand |
    | Italien  |


  @bug_1801
  @severity=minor
  Scenario Outline: Social network icons not displayed
    Given  Go to the page <smart-city>
    When   Scroll to the footer
    Then   Social network icons are replaced by squares

  Examples:
    |smart-city                             |
    |https://sagemcom.com/V02/fr/smart-city/|

  @bug_1650
  @severity=minor
  Scenario: Untranslated text in German
    Given Go to Sagemcom homepage
    When  Click on the German icon language to change the site language in german
    Then  Some texts in the navigation bar remain in english

  @bug_1717
  @severity=minor
  Scenario: Some items are displayed in the wrong language
    Given Go to Sagemcom homepage
    Then  Some items are in english but the site language is french

  @bug_1743
  @severity=minor
  Scenario Outline: Presence of English text on the French version
    Given  Go to the page <support>
    When   Scroll down to the section "recherche par catégorie"
    Then   There is "Read more" under each category

    Examples:
      |support                        |
      |https://support.sagemcom.com/fr|


