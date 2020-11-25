@citybike
Feature: City Bike Tests

  Background: User send Get request to end point
    Given User sets baseUri as "citybike_uri"
    When User sends GET request to endpoint
    Then Status code should be 200
    And Content Type should be JSON

  @citybike-01
  Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    And Expected city "Frankfurt" should be in "Germany"
    And Corresponded latitude should be in response
    And Corresponded longtitude should be in response

  @citybike-02
  Scenario Outline: As a user I want to verify that the following "<city>" is in "<country>"
    And Expected city "<city>" should be in "<country>"
    And Corresponded latitude should be in response
    And Corresponded longtitude should be in response
    Examples: cities and countries
      | city       | country        |
      | Moscow     | Russia         |
      | Copenhagen | Denmark        |
      | Madrid     | Spain          |
      | Berlin     | Germany        |
      | Istanbul   | Turkey         |
      | London     | United Kingdom |
      | Bruxelles  | Belgium        |
      | Torino     | Italy          |
      | Athens     | Greece         |
      | Zadar      | Croatia        |
      | Bremen     | Germany        |
      | Maastricht | Netherlands    |
      | Budapest   | Hungary        |
      | Dublin     | Ireland        |

  @citybike-03
  Scenario: As a user I want to verify that the location details are correct for the city
    And Following location details should be matching with city
      | city      | Paris     |
      | latitude  | 48.856613 |
      | longitude | 2.352222  |

