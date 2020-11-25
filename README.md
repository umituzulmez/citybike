# Citybike Project

•	Endpoint: http://api.citybik.es/v2/networks
•	Auth: No
•	HTTPS: No
•	Understands how the API works.
•	Create some BDD scenarios and automate them using Java to test the API
•	Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude”


In this project it is used Behaviour Driven and Data Driven Development approach.

The framework is based upon BDD/Cucumber DD Framework

It is consist of:
- citybikeTests
- runner
- stepDefinitions
- utilities
- features
- properties 
- pom.xml
- gitignore
packeges and files

Project is created by Maven as management tool

Test Cases are written in feature files with Gherkin Languages (plain English)
Cases are consist of Scenario and Scenario Outline approach supporting Data Driven Testing

Corresponding to each Test step, it is created stepDefinition methods to call and assert the expected and actual result

In citybukeTest file, it si created method corresponding each action by using Java languages

And also in Cukesrunner file, it supports to run all cases from one place. It is also added plugins to create reports to see test results

It is created gitignore file to put static constant files for ignoring them to push to repository 



