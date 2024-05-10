Feature: QA Job Page

  Background:
    Given user on the homepage

  @smoke
  Scenario: Qa List job postings and verify that the job application page is opened
    Then verify that "home page" is visible successfully
    When select "Company" main menu on homepage
    And select "Careers" submenu on homepage
    Then verify that "careers" is visible successfully
    And verify that teams, locations and life at insider section on careers page
    And click see all teams button on career page
    When click quality assurance team on career page
    And click see all qa jobs button on qa page
    And select "Istanbul, Turkey" as location and "Quality Assurance" as department on open positions page
    Then verify exists of jobs list on open positions page
    When click random view role button on open positions page
    Then verify that the job application page is open