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