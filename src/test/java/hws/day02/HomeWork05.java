package hws.day02;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HomeWork05 {
     /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
     @Test
     public void assertUserDetails() {
         // Send a GET request to the specified URL
         given()
                 .when()
                 .get("https://reqres.in/api/users/2")
                 .then()
                 .assertThat()
                 .statusCode(200) // Assert status code is 200
                 .contentType("application/json") // Assert response format is "application/json"
                 .body("data.email", equalTo("janet.weaver@reqres.in")) // Assert email is "janet.weaver@reqres.in"
                 .body("data.first_name", equalTo("Janet")) // Assert first_name is "Janet"
                 .body("data.last_name", equalTo("Weaver")) // Assert last_name is "Weaver"
                 .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")); // Assert text is "To keep ReqRes free, contributions towards server costs are appreciated!"
     }
}

