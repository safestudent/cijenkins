Feature: Hello

  User Story:
  In order to feel welcome
  As a user
  I need to be greeted by the website

  Rules:
  - User must be greeted when they arrive at the website

  Questions:
  - Is the home page the /hello page?

  To do:
  - Links on the hello page

  Domain language:
  - Greeting = 'Hello World'


  @high-impact
  Scenario: We're greeted
    When we navigate to the hello page
    Then we are greeted with the word Hello



