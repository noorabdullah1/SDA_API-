package day04;

import base_urls.JsonPlaceHolderBaseUrl;
import base_urls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C16_PostRequestNestedMap extends RestFullBaseUrl {
    /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 15,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2023-03-07",
                "checkout": "2024-09-25"
            },
            "additionalneeds": "Lunch"
           }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 2243,
                                            "booking": {
                                                "firstname": "John",
                                                "lastname": "Doe",
                                                "totalprice": 471,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                    "checkin": "2023-03-07",
                                                    "checkout": "2024-09-25"
                                                },
                                                "additionalneeds": "Lunch"
                                            }
                                        }
 */
    @Test
    public void postNestedMapTest() {
        // Set Url
        spec.pathParam("first", "booking");

        // Set Expected Data:

        // While dealing with nested structures start from inner structure

        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2023-03-07");
        bookingdates.put("checkout", "2024-09-25");

        Map<String, Object> payLoad = new HashMap<>();
        payLoad.put("firstname", "John");
        payLoad.put("lastname", "Doe");
        payLoad.put("totalprice", 15);
        payLoad.put("depositpaid", true);
        payLoad.put("bookingdates", bookingdates);
        payLoad.put("additionalneeds", "Lunch");

        // Send request and get response:
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        // Do assertion
//        response
//                .then()
//                .body("booking.firstname",equalTo(payLoad.get("firstname")));


        //response.as(Map.class);
    }


}