package com.citybike.citybikeTests;

import com.citybike.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Locale;
import java.util.Locale.*;

import java.beans.beancontext.BeanContextChild;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CitybikeTest {

    private static String baseUri;
    private static Response response;
    private static int countryRow;

    public static String baseURI(String uri){

        RestAssured.baseURI = ConfigurationReader.get(uri);
        baseUri = RestAssured.baseURI;
        return baseUri;
    }

   public static Response request(){

        response = given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .queryParam("fields", "location")
                .request(Method.GET);

        return response;
   }

    public static int validateStatusCode(int code){

        int statusCode = response.statusCode();

        return statusCode;
    }

    public static String validateContentType(){

        String contentType = response.contentType();

        return contentType;
    }

    public static String cityValidation(String city){

        String Country = "";
        List<String> cityNames = response.path("networks.location.city");

        for (int i = 0; i < cityNames.size(); i++) {

            if(cityNames.get(i).equals(city)){
                String countryCode = response.path("networks.location["+ i + "].country");

                Locale countryName = new Locale("", countryCode);
                Country = countryName.getDisplayCountry();

                countryRow = i;
            }

        }

        System.out.println(city + " is in " + Country);

        return Country;
    }

    public static float getLatitude(){

        float latitude = response.path("networks.location["+ countryRow + "].latitude");

        System.out.println("It is latitude = " + latitude);

        return latitude;
    }

    public static float getLongitude(){

        float longitude = response.path("networks.location["+ countryRow + "].longitude");

        System.out.println("It is longtitude = " + longitude);

        return longitude;
    }
}
