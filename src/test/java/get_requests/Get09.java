package get_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends JsonPlaceHolderBaseUrl {

     /*
        Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
    */

    @Test
    public void get09() {
        //Set the Url

        spec.pathParams("first", "todos", "second", 2); //bu url islemidir.

        //Set the expected data

        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
       Map<String, Object> expectedData = obj.getPayLoad(1, "quis ut nam facilis et officia qui", false);//burada objemiz payload degil,
        // body deki gibi degil, bu get request, get islemi yapiyoruz bize bir data geliyor. bana gelen data icin bekledigim data bu diyecegiz. karsidan gelen data da bu. bunlar birbirine esit mi diyecez.

        expectedData.put("id", 2);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");



        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion

        Map<String, Object> actualData = response.as(HashMap.class); //response u as araciligiyla hashmap classa dönüstürüyoruz.

        //bunu bizactualData adinda bir map a dönüstürdük artik. sonrada karsilastiracagiz asagidaki bilgi kontrolü ile.

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("Via"), response.header("Via"));
        assertEquals(expectedData.get("Server"), response.header("Server"));
    }
}
//payload u postlarda put larda kullanabiliyoruz.
//expecteddata yi ise get lerde kullaniyoruz. agirlikli olarak. beklenen davranis budur. geti postlarda kullanabilir ama istenen degildir.