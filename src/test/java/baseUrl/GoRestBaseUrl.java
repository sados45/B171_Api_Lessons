package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class GoRestBaseUrl { // PetStore classini diger metodlarimiza extend ederek calistiracagiz.
//interfacelerden obje olusturulamaz.
   protected RequestSpecification spec; // burada class seviyesinde tanimladik.
    // cunku diger diger classlara assign edecegimiz icin burada class seviyesinde olusturduk.

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder() //burada olusturdugumuz obje artik disardanda okunabilmesi icin
                // class seviyesine tasidigimiz icin RequestSpecification siliyoruz.iki farkli obje olusacagindan dolayi.
                .setBaseUri("https://gorest.co.in/public/v1")
                .setContentType(ContentType.JSON)
                .build();



    }
}

