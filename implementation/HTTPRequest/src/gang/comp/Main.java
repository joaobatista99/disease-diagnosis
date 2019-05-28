package gang.comp;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:5000/";
        String response = "";

        Map<String, String> json = new HashMap<String, String>();
        json.put("dog", "bla bla");
        json.put("dog1", "bla bla");
        json.put("dog2", "bla bla");
        System.out.println(json.get("dog"));

        HTTPRequest h = new HTTPRequest();
        try{
            response = h.GET(url, json);
        }catch(Exception e){
            ;
        }
        System.out.println(response);
    }
}
