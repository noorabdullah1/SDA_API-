package sda_Api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class StaticImportBaseURI {

    /*
Given Send GET request by adding static import to the class
Then assert that status code is 200
And assert that status line is HTTP/1.1 200 OK
 */

    @Test
    public void test() {
    String url = "https://reqres.in/api/users?page=2";
    Response response = given().when().get(url);

//        response
//                .then()
//                .statusCode(200)
//                .statusLine("HTTP/1.1 200 OK");

        // BETTER WAY
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
    }

    @Test
    public void test02() {
        baseURI = "https://reqres.in/api/";
        Response response= get("users?page=2");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
    }
    @Test
    public void test03() {
        baseURI = "https://reqres.in/api/";

        Response response = given()
                .pathParams("first","users")
                .queryParam("page","2")
                .get("/{first}");

        response.then().log().body();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.statusLine(),"HTTP/1.1 200 OK");
    }

}
