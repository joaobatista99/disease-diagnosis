package gang.comp.httprequest;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:5000/";

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("parameter1", "value1");
        parameters.put("parameter2", "value2");
        parameters.put("parameter3", "value3");;

        Map<String, String> auth = new HashMap<String, String>();
        auth.put("parameter1", "value1");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        String body = "{'asda':'asdas'}";

        HTTPRequest h = new HTTPRequest();
        try{
            h.GET(url, parameters, auth, headers);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println();
        try{
            h.POST(url, parameters, auth, headers, body);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
