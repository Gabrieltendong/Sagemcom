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