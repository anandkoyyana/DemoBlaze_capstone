
Feature: Feature is to test check the functionalities of DemoBlaze Application.

@login
Scenario: validate the login functionality 

Given open the Browser
Then user is on DemoBlaze page
When User enters username and password as "<username>" and "<password>"
Then user clicks on login button
And  Close The browser

Examples:
|username|password|
|pingu|pingu123|
|pingu||
 