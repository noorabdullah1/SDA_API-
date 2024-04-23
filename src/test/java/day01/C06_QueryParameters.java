package day01;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06_QueryParameters {
        /*
    Given
       https://restful-booker.herokuapp.com/booking
    When
       User sends a GET request to the URL
    Then
       Status code is 200
    And
       Among the data, there should be someone whose first name is "JOHN" and last name is "Smith"
*/

    @Test
    public void queryParametersTest() {

//        1. Set the URL
        String url ="https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith";
//        2. Set the expected data

//        3. Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

//        4. Do Assertion

        //1st way:

        //2nd way:

    }
}