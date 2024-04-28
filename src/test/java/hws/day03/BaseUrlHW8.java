package hws.day03;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseUrlHW8 {

        protected RequestSpecification spec;

        @BeforeMethod
        public void setUp() {
            spec = new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setContentType(ContentType.JSON)
                    .build();
        }
    }
