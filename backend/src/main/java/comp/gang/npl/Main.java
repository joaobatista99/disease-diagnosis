package comp.gang.npl;

// Imports the Google Cloud client library

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instantiates a client
        NPL teste = new NPL();

        System.out.println(teste.sense("Não senti nada."));
    }
}