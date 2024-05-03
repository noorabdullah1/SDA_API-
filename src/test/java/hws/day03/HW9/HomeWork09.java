package hws.day03.HW9;

import hws.day03.HW12.UserPojoHW12;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
public class HomeWork09 extends BaseUrlHW9_10 {
/*
Write an automation test that will create a 'user'
using the "https://petstore.swagger.io/" document
*/

    @Test
    public void createUser(){
        //Set Url
        spec.pathParam("first","user");
        //Set Expected Data
        UserPojoHW12 payLoad =new UserPojoHW12(0
                ,"UserTest"
                ,"userFirstName"
                ,"userLastName"
                ,"email@test"
                ,"2138"
                ,"12555555"
                ,0);

        //Send POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();
        //Do Assertions
        assertEquals(200,response.statusCode());
        spec.pathParam("second",payLoad.getUsername());
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        UserPojoHW12 actualData = response.as(UserPojoHW12.class);
        //Do Assertions For GET Request
        assertEquals(payLoad.getUsername(), actualData.getUsername());
        assertEquals(payLoad.getFirstName(),actualData.getFirstName());
        assertEquals(payLoad.getLastName(), actualData.getLastName());
        assertEquals(payLoad.getEmail(), actualData.getEmail());
        assertEquals(payLoad.getPassword(),actualData.getPassword());
        assertEquals(payLoad.getPhone(), actualData.getPhone());


    }
}
