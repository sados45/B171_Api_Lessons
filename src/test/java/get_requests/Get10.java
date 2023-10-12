package get_requests;

import baseUrl.HerokuAppBaseUrl;
import org.junit.Test;

public class Get10 extends HerokuAppBaseUrl {

     /*
    Given
        https://restful-booker.herokuapp.com/booking/91
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


    }
}


