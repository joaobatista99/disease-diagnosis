package comp.gang.doctor;

import comp.gang.npl.NPL;
import java.util.HashMap;
import java.util.Map;

public class Doctor implements IDoctor {
    private String []   symptoms; // vetor dos possíves sintomas. Ex.: Paralisia, Lingua Amarela, etc.
    private String [][] diagnosis; // matriz dos sintomas e seus respectivos diagnósticos seguindo a ordem do vetor de symptoms

    private int [] possibleDiagnosis; // vetor com os indices (da matriz diagnosis) dos possíveis diagnósticos
    private int lenPossibleDiagnosis; // tamanho do vetor de possibleDiagnosis

    private int indSymptomToAsk; // inteiro que indica qual symptom está sendo perguntado ao paciente

    private NPL patientTranslator; // objeto que usa linguagem natural para interpretar a resposta do paciente;

    // CONTRUTOR
    public Doctor() {
        initFromCSV("csv/zombie-health-new-cases500.csv");

        this.indSymptomToAsk = filterDiagnosisAndCalcNextBest(-1, true);

        this.patientTranslator = new NPL();
    }

    // popula a matriz de diagnósticos com seus respectivos sintomas
    // e o vetor de sintomas
    private void initFromCSV (String strToFile) {
        DataSetComponent dsc = new DataSetComponent();
        dsc.setDataSource("csv/zombie-health-new-cases500.csv");

        this.symptoms = dsc.requestAttributes();
        this.diagnosis = dsc.requestInstances();
        this.lenPossibleDiagnosis = this.diagnosis.length;
        this.possibleDiagnosis = new int [this.lenPossibleDiagnosis];

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            this.possibleDiagnosis[i] = i;
        }
    }

    // atualiza os possibleDiseases a partir do sintoma que se perguntou ao paciente e
    // calcula e retorna qual é o melhor próx sintoma a se perguntar, retorna 1 caso não há mais o q perguntar
    // se symptom == -1 indica que é a primeira vez que a busca pela melhor pergunta está sendo feita
    private int filterDiagnosisAndCalcNextBest(int symptom, boolean isFeeling) {
        int newLenPossibleDiagnosis = 0;

        // vetor que conta quantos dos diagnósticos estão sentindo determinado sintoma
        // -1 pois o ultimo eh o diagnśotico e não um sintoma
        // vetor de inteiros já inicializados com zeros
        int[] countSymptoms = new int[this.symptoms.length - 1];

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            int indCurrentDiagnose = this.possibleDiagnosis[i];
            String [] currentSymptoms = this.diagnosis[indCurrentDiagnose];

            // se o paciente está sentindo o sintoma, ele continua no vetor de possibleDiagnosis
            if (symptom == -1 || currentSymptoms[symptom].equals("1") == isFeeling) {
                this.possibleDiagnosis[newLenPossibleDiagnosis] = indCurrentDiagnose;
                newLenPossibleDiagnosis++;

                for (int j = 0;j < countSymptoms.length;j++) {
                    // se o sintoma está sendo sentido no diagnóstico, ele é incrementado
                    countSymptoms[j] += currentSymptoms[j].equals("1") ? 1 : 0;
                }
            }
        }

        this.lenPossibleDiagnosis = newLenPossibleDiagnosis;

        // calcula-se qual é o sintoma que tem uma razão (entre sentir ou não) mais próxima de 0.5 dos diagnósticos
        int nextSymptom = 0;

        boolean onlyOneSymptom = countSymptoms[0] == 0 || countSymptoms[0] == newLenPossibleDiagnosis;
        double ratio = onlyOneSymptom ? 0 : (float) countSymptoms[0] / newLenPossibleDiagnosis;
        double smallerAprox = Math.abs(0.5 - ratio);
        boolean diagnoseReady = onlyOneSymptom;

        for (int i = 1;i < countSymptoms.length;i++) {
            // tem apenas um sintoma para todos os diagnósticos apresentados ou tudo true ou tudo false
            onlyOneSymptom = countSymptoms[i] == 0 || countSymptoms[i] == newLenPossibleDiagnosis;

            ratio = onlyOneSymptom ? 0 : (float) countSymptoms[i] / newLenPossibleDiagnosis;
            double aprox = Math.abs(0.5 - ratio);

            diagnoseReady &= onlyOneSymptom;

            if (aprox < smallerAprox) {
                smallerAprox = aprox;
                nextSymptom = i;
            }
        }

        return diagnoseReady ? -1 : nextSymptom;
    }

    private String questionFromIndSymptom (int indSymptom) {
        return "Você está sentindo " + this.symptoms[indSymptom] + "?";
    }

    private String getBestDiagnosis() {
        Map<String, Integer> dic = new HashMap<String, Integer>();

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            String diagnosis = this.diagnosis[this.possibleDiagnosis[i]][this.symptoms.length - 1];
            if (!dic.containsKey(diagnosis)) {
                dic.put(diagnosis, 0);
            } else {
                dic.put(diagnosis, dic.get(diagnosis) + 1);
            }
        }

        Integer maxOccurrences = 0;
        String bestDiagnosis = "";
        for (String diagnosis : dic.keySet()) {
            int occurrences = dic.get(diagnosis);

            if (occurrences > maxOccurrences) {
                bestDiagnosis = diagnosis;
                maxOccurrences = occurrences;
            }
        }

        return bestDiagnosis;
    }

    public boolean hasQuestions () {
        return this.indSymptomToAsk != -1;
    }

    public String nextQuestion () {
        return questionFromIndSymptom(this.indSymptomToAsk);
    }

    public void answerQuestion (String answer) {
        try {
            boolean feeling = patientTranslator.sense(answer);
            this.indSymptomToAsk = filterDiagnosisAndCalcNextBest(this.indSymptomToAsk, feeling);
        } catch (Exception e) {
            System.out.println("Erro com NPL");
            e.printStackTrace();
        }
    }

    public String getDiagnosis () {
        for (int i = 0; i < this.lenPossibleDiagnosis; i++) {
            String strDiagnose = "";

            for (int j = 0;j < 9;j++) {
                strDiagnose += this.diagnosis[this.possibleDiagnosis[i]][j] + ", ";
            }

            System.out.println(strDiagnose);
        }

        return getBestDiagnosis();
    }
}
