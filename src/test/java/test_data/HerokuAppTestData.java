package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {
// iki jsondata oldugu icin iki ayri method olusturacagiz.

public Map<String, String> getBookingDates(String checkin, String checkout ){
    Map<String, String> bookingdatesData = new HashMap<>();
    bookingdatesData.put("checkin", checkin);
    bookingdatesData.put("checkout", checkout);

    return bookingdatesData;
}

public  Map<String, String> getPayLoad(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds ){
    Map<String, Object> expectedData = new HashMap<>();                                                             //burada bookingdates zaten yukarida yapildi ayri bir map ile. bu nedenle bu sekilde yaziliyor buraya.
    expectedData.put("firstname", firstname);
    expectedData.put("lastname", lastname);
    expectedData.put("totalprice",totalprice);
    expectedData.put("depositpaid", depositpaid);
    expectedData.put("bookingdates", bookingdates); // kücük olani büyük olanin icine koyduk. büyük olan expecteddata idi.  yukarida bize verilen icice olan veri bilgisine dayali olarak.
    expectedData.put("additionalneeds", additionalneeds);

    return bookingdates;
}


}

/*
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

 */