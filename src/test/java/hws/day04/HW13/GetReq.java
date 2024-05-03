package hws.day04.HW13;

import hws.day03.HW12.UserPojoHW12;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

import hws.day03.HW9.BaseUrlHW9_10;

public class GetReq extends BaseUrlHW9_10 {
    @Test
    public void getRequest(){

        //SetUrl
        spec.pathParams("first","user","second","Noorbabahr");
        //Set expected Data
        String expectedStr = """
                {
                  "id": 0,
                  "username": "Noorbabahr",
                  "firstName": "Noor",
                  "lastName": "babahr",
                  "email": "test@test",
                  "password": "123456",
                  "phone": "12456987",
                  "userStatus": 0
                }""";

        UserPojoHW12 expectedData= convertJsonToJava(expectedStr,UserPojoHW12.class);

        //Send Post Request and get Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        UserPojoHW12 actualData = convertJsonToJava(response.asString(),UserPojoHW12.class);

        //Do assertions
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUsername(),actualData.getUsername());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getPassword(),actualData.getPassword());
        assertEquals(expectedData.getPhone(),actualData.getPhone());
        assertEquals(expectedData.getUserStatus(),actualData.getUserStatus());
    }
}

