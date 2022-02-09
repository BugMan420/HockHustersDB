Feature: Is the language English?
  People want to know if the movie is in English
  Scenario: Language is English
    Given The films language is "English"
    When I click the language button
    Then I can see "English" as an option



