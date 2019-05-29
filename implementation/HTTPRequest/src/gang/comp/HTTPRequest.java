package gang.comp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;


public class HTTPRequest implements IHTTPRequest{
    public String POST(String url_string, Map parameters, Map both, Map auth) throws Exception{

        StringBuilder result = new StringBuilder();
        URL url = new URL(url_string +"?"+
                ParameterStringBuilder.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("Establishing connection to url: "+url.toString());
        con.setRequestMethod("POST");
        System.out.println("Method:" + con.getRequestMethod());

        con.setAuthenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        auth.get("user").toString(), auth.get("password").toString().toCharArray());
            }
        });


        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Response: "+result.toString());
        return result.toString();

        /*try{
            URL url = new URL("http://0.0.0.0:5000/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println(con.getResponseMessage());
            //con.setDoOutput(true);
            //DataOutputStream out = new DataOutputStream(con.getOutputStream());
            //out.flush();
            //out.close();
        }catch(Exception e){
            System.out.println(e);

        }
        return "asda";*/
    }

    public String GET(String url_string, Map parameters, Map auth, Map headers) throws Exception {

        StringBuilder result = new StringBuilder();
        URL url = new URL(url_string +"?"+
                ParameterStringBuilder.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("Establishing connection to url: "+url.toString());
        con.setRequestMethod("GET");
        System.out.println("Method:" + con.getRequestMethod());
        con.setAuthenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        auth.get("user").toString(), auth.get("password").toString().toCharArray());
            }
        });

        /*for (Map.Entry<String, String> entry : headers.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Response: "+result.toString());
        return result.toString();

    }

}


