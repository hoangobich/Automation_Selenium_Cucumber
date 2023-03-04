Feature: login

  Background: navigate to the php travels
    Given navigate to the php travels home page

  @tc1
  Scenario Outline: login success dashboard is displayed
    When login to the php travels with "<email>" and "<password>"
    Then login display default screen dashboard is correct
    Examples:
      | email                | password  |
      | admin@phptravels.com | demoadmin |

  @tc2
  Scenario: check information placeholder email and password and is selected remember me
    When click button remember me
    Then verify button remember me selected success
    Then verify information placeholder email and password is correct

