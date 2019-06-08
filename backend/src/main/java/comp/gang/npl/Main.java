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

        String [] s = {"Não senti nada.", "Não senti", "Não", "Nada", "Sim, senti um pouco", "Sim, senti muito", "Sim", "Sim!", "Com certeza", "Senti um pouco dor de cabeça", "Ontem eu senti muita dor de cabeça, mas hoje não senti nada", "Estava sentindo, mas melhorei então estou bem com relação a dor de cabeça"};

        for (String str : s) {
            System.out.println(str + ": " + Boolean.toString(teste.sense(str)));
        }
    }
}