package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Post02 extends JsonPlaceHolderBaseUrl {

          /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
           */

    @Test
    public void post02() {

        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data (payLoad)
        // PayLoad: Post işlemlerinde Body ile gönderdiğimiz datadır.
        // Expected Data: Response'tan gelmesini beklediğimiz datadır.
        String payLoad = "{ \n" +
                "             \"userId\": 55, \n" +
                "             \"title\": \"Tidy your room\", \n" +
                "             \"completed\": false \n" +
                "           }";

        // Send the request and get the response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        // Do assertion
        JsonPath json = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals(55, json.getInt("userId"));
        assertEquals("Tidy your room", json.getString("title"));
        assertFalse(json.getBoolean("completed"));
    }
}