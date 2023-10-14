package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {


    public Map<String, Object> getPayLoad(Integer userId, String title, boolean completed){

        Map<String, Object> payLoad = new HashMap<>();

        if(userId != null) {

            payLoad.put("userId", userId);

        } // bunu if li yapi neden yazildi. eger userId null degilse mesela 25se, 25 olacak userId if li yapida korunacak degilse null olacak yani.

        if(title != null) {

            payLoad.put("title", title);

        } // ayni sey gecerli.

        if(title != null) {

            payLoad.put("completed", completed);

        } // bunlar null olursa put metodu calistirilmamis olacak.






        return payLoad;
    }

}
