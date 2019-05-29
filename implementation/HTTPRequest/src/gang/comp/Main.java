package gang.comp;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:5000/";
        String response;

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("parameter1", "value1");
        parameters.put("parameter2", "value2");
        parameters.put("parameter3", "value3");;

        Map<String, String> auth = new HashMap<String, String>();
        auth.put("parameter1", "value1");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("parameter1", "value1");

        HTTPRequest h = new HTTPRequest();
        try{
            response = h.GET(url, parameters, auth, headers);
        }catch(Exception e){
            System.out.println(e);
        }
        //System.out.println(response);
    }
}
