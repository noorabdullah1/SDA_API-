package day06;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStore.Category;
import pojos.PetStore.PetStoreResponse;
import pojos.PetStore.TagsItem;
import utilities.ObjectMapperUtilities;

import static io.restassured.RestAssured.given;

public class C29_PetStorePetMethods extends PetStoreBaseUrl {

    int id = 200;
    PetStoreResponse payload;
    @Test
    public void createPetTest(){
        // Set Url
        spec.pathParam("first","pet");

        // Set Expected Data
        // 1st way by Object
        String payloadStr = """
                {
                  "id": 200,
                  "category": {
                    "id": 3,
                    "name": "Doggie"
                  },
                  "name": "Aldo",
                  "photoUrls": [
                    "string","another"
                  ],
                  "tags": [
                    {
                      "id": 1,
                      "name": "Cute"
                    },
                    {
                      "id": 2,
                      "name": "Cheap"
                    }
                  ],
                  "status": "available"
                }""";

         payload = ObjectMapperUtilities.convertJsonToJava(payloadStr, PetStoreResponse.class);
        //payload.getTags().get(1).getName().

        // Second way

        // Send Request and Get Response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test(dependsOnMethods = "createPetTest")
    public void getPetTest(){
        //Set Url
        spec.pathParams("first","pet"
        ,"second",id);

        // Set Expected Data

        // 1st way by Object

        // Sent Request and Get Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test(dependsOnMethods = "createPetTest")
    public void updatePetTest(){
        // Set Url
        spec.pathParam("first","pet");

        // Set Expected Data

        //PetStoreResponse payload = ObjectMapperUtilities.convertJsonToJava(payloadStr, PetStoreResponse.class);

        payload.setName("Aslan");
        payload.getTags().get(0).setName("Sick");
        payload.setStatus("pending");

        // System.out.println("payload = " + payload);
        // Send Request and Get Response
        Response response = given(spec).body(payload). put("{first}");
        response.prettyPrint();
    }

}
