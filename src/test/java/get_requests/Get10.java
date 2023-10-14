package get_requests;
import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Get10 extends HerokuAppBaseUrl {
    /*
     Given
         https://restful-booker.herokuapp.com/booking/23
     When
         I send GET Request to the url
     Then
         Response body should be like that;
             {
                 "firstname": "Jane",
                 "lastname": "Doe",
                 "totalprice": 111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2018-01-01",
                     "checkout": "2019-01-01"
                 },
                 "additionalneeds": "Extra pillows please"
             }
      */
    @Test
    public void get10() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 4375);
        // Set the expected data
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jane");
        expectedData.put("lastname", "Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDates); // kücük olani büyük olanin icine koyduk. büyük olan expecteddata idi.  yukarida bize verilen icice olan veri bilgisine dayali olarak. 
        expectedData.put("additionalneeds", "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingDates.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingDates.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

        // 2. YOL      //yukaridaki son iki satir da map kismi zor oldugu icin kolay yolu asagidadir. 
        JsonPath json = response.jsonPath();
        assertEquals(bookingDates.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingDates.get("checkout"), json.getString("bookingdates.checkout"));

//        Object obj = new HashMap<>();
//        ((Map)obj).get("checkin");
    }

    @Test
    public void get10Metotlu() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 4375);
        // Set the expected data
        Map<String, String> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", "2018-01-01");
        bookingDatesData.put("checkout", "2019-01-01");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jane");
        expectedData.put("lastname", "Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDatesData); // kücük olani büyük olanin icine koyduk. büyük olan expecteddata idi.  yukarida bize verilen icice olan veri bilgisine dayali olarak.
        expectedData.put("additionalneeds", "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingDatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingDatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

        // 2. YOL      //yukaridaki son iki satir da map kismi zor oldugu icin kolay yolu asagidadir.
        JsonPath json = response.jsonPath();
        assertEquals(bookingDatesData.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingDatesData.get("checkout"), json.getString("bookingdates.checkout"));


    }
}

