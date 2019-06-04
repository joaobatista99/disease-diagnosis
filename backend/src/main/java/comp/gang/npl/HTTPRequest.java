package comp.gang.npl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Map;


public class HTTPRequest implements IHTTPRequest {
    public String POST(String url_string, Map parameters, Map auth, Map<String,String> headers, String body) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(url_string +"?"+
                ParameterStringBuilder.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("Establishing connection to url: "+url.toString());
        con.setRequestMethod("GET");
        System.out.println("Method:" + con.getRequestMethod());
        /*con.setAuthenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        auth.get("user").toString(), auth.get("password").toString().toCharArray());
            }
        });*/
        System.out.println("Headers: ");
        for (Map.Entry<String,String> entry: headers.entrySet()) {
            System.out.println("\tKey:"+entry.getKey() + "\tValue:" + entry.getValue());
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }

        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        System.out.println("Response: "+result.toString());
        return result.toString();

    }

    public String GET(String url_string, Map parameters, Map auth, Map<String,String> headers) throws Exception {

        StringBuilder result = new StringBuilder();
        URL url = new URL(url_string +"?"+
                ParameterStringBuilder.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println("Establishing connection to url: "+url.toString());
        con.setRequestMethod("GET");
        System.out.println("Method:" + con.getRequestMethod());
        /*con.setAuthenticator(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        auth.get("user").toString(), auth.get("password").toString().toCharArray());
            }
        });*/
        System.out.println("Headers: ");
        for (Map.Entry<String,String> entry: headers.entrySet()) {
            System.out.println("\tKey:"+entry.getKey() + "\tValue:" + entry.getValue());
            con.setRequestProperty(entry.getKey(), entry.getValue());
        }

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


