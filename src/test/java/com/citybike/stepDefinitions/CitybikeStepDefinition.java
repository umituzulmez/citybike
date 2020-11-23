package com.citybike.stepDefinitions;

import com.citybike.citybikeTests.CitybikeTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CitybikeStepDefinition {

    @Given("User sets baseUri as {string}")
    public void user_sets_baseUri_as(String uri) {

        CitybikeTest.baseURI(uri);
    }

    @When("User sends GET request to endpoint")
    public void user_sends_GET_request_to_endpoint() {

        CitybikeTest.request();
    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {

        int code = CitybikeTest.validateStatusCode(statusCode);

        Assert.assertEquals(code, statusCode);
    }

    @Then("Content Type should be JSON")
    public void content_Type_should_be_JSON() {

        String contentType = CitybikeTest.validateContentType();

        Assert.assertEquals("application/json", contentType);
    }

    @Then("Expected city {string} should be in {string}")
    public void expected_city_should_be_in(String city, String country) {

        String Country = CitybikeTest.cityValidation(city);

        Assert.assertEquals(country,Country);
    }

    @Then("Corresponded latitude should be in response")
    public void corresponded_latitude_should_be_in_response() {

        String latitude = String.valueOf((CitybikeTest.getLatitude()));

        Assert.assertFalse(latitude.isEmpty());
    }

    @Then("Corresponded longtitude should be in response")
    public void corresponded_longtitude_should_be_in_response() {

        String longitude = String.valueOf((CitybikeTest.getLongitude()));

        Assert.assertFalse(longitude.isEmpty());
    }

    @Then("Following location details should be matching with city")
    public void following_location_details_should_be_matching_with_city(Map<String,String> cityData) {

        CitybikeTest.cityValidation(cityData.get("city"));

        String expectedLatitude = cityData.get("latitude");
        String expectedLongitude = cityData.get("longitude");

        String actualLatitude = String.valueOf(CitybikeTest.getLatitude());
        String actualLongitude = String.valueOf(CitybikeTest.getLongitude());

        Assert.assertEquals(expectedLatitude,actualLatitude);
        Assert.assertEquals(expectedLongitude,actualLongitude);

    }

}
