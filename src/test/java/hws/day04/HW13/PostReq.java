package hws.day04.HW13;

import com.fasterxml.jackson.databind.ObjectMapper;
import hws.day03.HW12.UserPojoHW12;
import hws.day03.HW9.BaseUrlHW9_10;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtilities;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class PostReq extends BaseUrlHW9_10 {
    @Test
    public void postRequest(){

        //SetUrl
        spec.pathParam("first","user");
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
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do assertions
        assertEquals(200,response.statusCode());

    }

}
