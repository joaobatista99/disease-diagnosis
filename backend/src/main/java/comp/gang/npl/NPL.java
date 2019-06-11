package comp.gang.npl;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

public class NPL {
    public boolean sense(String text) throws Exception {
        try {

            LanguageServiceClient language = LanguageServiceClient.create();

            Document doc = Document.newBuilder()
                    .setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

            /*
            System.out.printf("Text: %s%n", text);
            System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());

            */

            return sentiment.getScore() >= 0.0;

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
