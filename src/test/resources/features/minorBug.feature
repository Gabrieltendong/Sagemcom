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