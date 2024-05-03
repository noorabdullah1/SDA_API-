package hws.day03.HW12;

import hws.day03.HW9.UserPojoHW8;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;


public class HomeWork12 extends BaseUrlHW12{
/*
//Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
(All actions must be done on same pet)
(Use Pojo)
 */
public static UserPojoHW8 payLoad;
    public Integer id = 12555553;
    @Test
    public void postRequest(){
        //Set Url
        spec.pathParam("first","pet");
        //Set expected Data
        //Create a List of tags to match Json Syntax type
        List<PetTagPojoHW12> tagList= new ArrayList<>();
        tagList.add(new PetTagPojoHW12(11,"Tag4"));

        payLoad = new UserPojoHW8(id
                ,new PetCategoryPojoHW12(555,"cat")
                ,"Kitten"
                ,new ArrayList<String>(Arrays.asList("image1","image2"))
                ,tagList
                ,"Available");

        //Send POST Request
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        UserPojoHW8 actualData= response.as(UserPojoHW8.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());

        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());


    }

    @Test(dependsOnMethods = "postRequest")
    public void getRequest(){
        //Set Url
        spec.pathParams("first","pet"
                ,"second",id);
        //Set expected Data
        //Create a List of tags to match Json Syntax type

        //Send GET Request
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        UserPojoHW8 actualData= response.as(UserPojoHW8.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());

        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());
    }

    @Test(dependsOnMethods = "postRequest")
    public void putRequest(){
        //Set Url
        spec.pathParams("first","pet");

        //Set expected Data
        //Change the Name to Luna
        payLoad.setName("Luna");

        //Send PUT Request
        Response response = given(spec).body(payLoad).when().put("{first}");
        response.prettyPrint();

        UserPojoHW8 actualData= response.as(UserPojoHW8.class);
        //Do Assertions
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getId(),actualData.getId());
        assertEquals(payLoad.getCategory().toString(), actualData.getCategory().toString());
        assertEquals(payLoad.getName(),actualData.getName());
        assertEquals(payLoad.getPhotoUrls(), actualData.getPhotoUrls());
        assertEquals(payLoad.getTags().toString(),actualData.getTags().toString());
        assertEquals(payLoad.getStatus(),actualData.getStatus());

    }

    @Test(dependsOnMethods = "postRequest",priority = 1)
    public void deleteRequest(){
        //Set Url
        spec.pathParams("first","pet"
                ,"second",id);
        //Set expected Data

        //Send DELETE Request
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .body("message",equalTo(id+""));
        assertEquals(200,response.statusCode());

        //Do Assertions For GET Request to make sure the data was deleted
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        //Do Assertions
        assertEquals(404,response.statusCode());


    }
}