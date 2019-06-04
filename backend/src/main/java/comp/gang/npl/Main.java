package comp.gang.npl;

// Imports the Google Cloud client library
/*
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instantiates a client
        try {
            LanguageServiceClient language = LanguageServiceClient.create();

            // The text to analyze
            String text = "Hello, world!";
            Document doc = Document.newBuilder()
                    .setContent(text).setType(Type.PLAIN_TEXT).build();

            // Detects the sentiment of the text
            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

            System.out.printf("Text: %s%n", text);
            System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}*/

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String url = "http://0.0.0.0:5000/";

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("parameter1", "value1");
        parameters.put("parameter2", "value2");
        parameters.put("parameter3", "value3");
        ;

        Map<String, String> auth = new HashMap<String, String>();
        auth.put("parameter1", "value1");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        String body = "{'asda':'asdas'}";

        HTTPRequest h = new HTTPRequest();
        try {
            h.GET(url, parameters, auth, headers);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
        try {
            h.POST(url, parameters, auth, headers, body);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}