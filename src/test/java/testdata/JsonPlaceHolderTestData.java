package testdata;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public static Map<String, Object> jsonPlaceHolderMapper(Integer userId, String title , Boolean completed){
        Map<String, Object> payLoad = new HashMap<>();

        payLoad.put("userId",userId);
        payLoad.put("title",title);
        payLoad.put("completed",completed);
        return payLoad;
    }
}
