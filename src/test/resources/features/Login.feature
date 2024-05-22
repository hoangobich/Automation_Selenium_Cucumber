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
  Scenario Outline: check information placeholder email and password and is selected remember me
    When click button remember me
    Then verify button remember me selected success
    Then verify information placeholder email and password is correct
    Examples:

  @tc3
  Scenario Outline: Navidate to facebook
    Given navigate to "<url>"
    Examples:
      | url                                        |
      | https://m.facebook.com/login/?locale=vi_VN |

