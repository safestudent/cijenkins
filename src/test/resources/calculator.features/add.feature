Feature: Calculator

  User Story:
  In order to perform numeric calculations
  As a user
  I need to be able to enter numbers and see the result

  Rules:
  - It must be done through a website
  - You have one page for each type of calculation

  Questions:
  - Do you need to have buttons to press for the numbers?

  To do:
  - Negative tests

  Domain language:
  - result = the result of a calculation

@high-impact
Scenario Outline: We add two numbers
Given we navigate to the add page
When we add <number1> and <number2>
Then we have <result>
Examples:
| number1 | number2 | result |
|1        |2        |3       |