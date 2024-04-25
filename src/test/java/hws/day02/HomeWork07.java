package hws.day02;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class HomeWork07 {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void assertResponse() {
        // Send a GET request to the specified URL
        given()
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .assertThat()
                .statusCode(200); // Assert status code is 200

        // Print all pantone_values
        given()
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .log().body()
                .body("data.pantone_value", not(empty()));

        // Print all ids greater than 3 and assert that there are 3 ids greater than 3
        given()
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .log().body()
                .body("data.findAll{it.id > 3}.id", hasSize(3));

        // Print all names whose ids are less than 3 and assert that the number of names is 2
        given()
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .log().body()
                .body("data.findAll{it.id < 3}.name", hasSize(2));
    }
}