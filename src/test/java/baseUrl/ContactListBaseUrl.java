package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationContactList.generateToken;


public class ContactListBaseUrl {


   protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder()

                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + generateToken())
                //get06 dan sildik headeri buraya addheader yaptik.
                .build();

    }
}