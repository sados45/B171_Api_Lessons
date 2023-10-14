package patch_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl { //Patch de parcali datayi mesela bir kismini gönderebiliyoruz sadece.bütün body kullanmak zorunda degiliz.


 /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
              "title": "Wash the dishes"
           }
    When
      I send PATCH Request to the Url
    Then
          Status code is 200
          And response body is like
              {
                "userId": 10,
                "title": "Wash the dishes",
                "completed": true,
                "id": 198
              }
     */

    public void patch01() {

        // Set the Url

        spec.pathParams("first", "todos", "second", "198");

   // Set the expected data

        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();                        //altta null hata verdi, boolean olmali diyor.
        Map<String, Object> payLoad = obj.getPayLoad(null, "Wash the dishes", null); //  neden null girdik, cunku sadece title göndermek istiyotuz.
        //burada userId yi null yapti, completed i da. burada bir film cevirecegiz. JsonPlaceHolderDatanin icinde if li kod yazacaz.
        Map<String, Object> expectedData = obj.getPayLoad(10, "Wash the dishes", true);// burada expected i assertion larda data yazmamak icin olusturduk.
        System.out.println(expectedData);


        //Send the request and get the response

        Response response =given(spec).body(payLoad).when().patch("{first}/{second}"); //serialization javayi json datasina dönüstürüyor.
        response.prettyPrint();

        // sonuc olarak sadece title gönderildi. digerleri yok. null yapildi patch li methodda...


        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);  // De-Serialization ->  gelen json data hashmap dönüstürüyoruz. karsilatirabilmek icin. expecteddata ile actualdata

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));


    }
}


