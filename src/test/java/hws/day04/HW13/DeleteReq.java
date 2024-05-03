package hws.day04.HW13;

import hws.day03.HW9.BaseUrlHW9_10;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class DeleteReq extends BaseUrlHW9_10 {
    //Write an automation test that will create a 'user'
    // then read,
    // update
    // and delete the created user
    // using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
    @Test
    public void deleteRequest(){

        //SetUrl
        spec.pathParams("first","user","second","Noorbabahr");

        //Send Post Request and get Response
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        assertEquals(200,response.statusCode());
        //Send Get Request to verify the username is no longer exist
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        assertEquals(404,response.statusCode());

    }

}
