package comp.gang.doctor;

import comp.gang.npl.NPL;
import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private String []   symptons; // vetor dos possíves sintomas. Ex.: Paralisia, Lingua Amarela, etc.
    private String [][] diagnosis; // matriz dos sintomas e seus respectivos diagnósticos seguindo a ordem do vetor de symptons

    private int [] possibleDiagnosis; // vetor com os indices (da matriz diagnosis) dos possíveis diagnósticos
    private int lenPossibleDiagnosis; // tamanho do vetor de possibleDiagnosis

    private int indSymptonToAsk; // inteiro que indica qual sympton está sendo perguntado ao paciente

    private NPL patientTranslator; // objeto que usa linguagem natural para interpretar a resposta do paciente;

    // CONTRUTOR
    public Doctor() {
        initFromCSV("csv/zombie-health-new-cases500.csv");

        this.indSymptonToAsk = filterDiagnosisAndCalcNextBest(-1, true);

        this.patientTranslator = new NPL();
    }

    // popula a matriz de diagnósticos com seus respectivos sintomas
    // e o vetor de sintomas
    private void initFromCSV (String strToFile) {
        DataSetComponent dsc = new DataSetComponent();
        dsc.setDataSource("csv/zombie-health-new-cases500.csv");

        this.symptons = dsc.requestAttributes();
        this.diagnosis = dsc.requestInstances();
        this.lenPossibleDiagnosis = this.diagnosis.length;
        this.possibleDiagnosis = new int [this.lenPossibleDiagnosis];

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            this.possibleDiagnosis[i] = i;
        }
    }

    // atualiza os possibleDiseases a partir do sintoma que se perguntou ao paciente e
    // calcula e retorna qual é o melhor próx sintoma a se perguntar, retorna 1 caso não há mais o q perguntar
    // se sympton == -1 indica que é a primeira vez que a busca pela melhor pergunta está sendo feita
    private int filterDiagnosisAndCalcNextBest(int sympton, boolean isFeeling) {
        int newLenPossibleDiagnosis = 0;

        // vetor que conta quantos dos diagnósticos estão sentindo determinado sintoma
        // -1 pois o ultimo eh o diagnśotico e não um sintoma
        // vetor de inteiros já inicializados com zeros
        int[] countSymptons = new int[this.symptons.length - 1];

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            int indCurrentDiagnose = this.possibleDiagnosis[i];
            String [] currentSymptons = this.diagnosis[indCurrentDiagnose];

            // se o paciente está sentindo o sintoma, ele continua no vetor de possibleDiagnosis
            if (sympton == -1 || currentSymptons[sympton].equals("1") == isFeeling) {
                this.possibleDiagnosis[newLenPossibleDiagnosis] = indCurrentDiagnose;
                newLenPossibleDiagnosis++;

                for (int j = 0;j < countSymptons.length;j++) {
                    // se o sintoma está sendo sentido no diagnóstico, ele é incrementado
                    countSymptons[j] += currentSymptons[j].equals("1") ? 1 : 0;
                }
            }
        }

        this.lenPossibleDiagnosis = newLenPossibleDiagnosis;

        // calcula-se qual é o sintoma que tem uma razão (entre sentir ou não) mais próxima de 0.5 dos diagnósticos
        int nextSympton = 0;

        boolean onlyOneSympton = countSymptons[0] == 0 || countSymptons[0] == newLenPossibleDiagnosis;
        double ratio = onlyOneSympton ? 0 : (float) countSymptons[0] / newLenPossibleDiagnosis;
        double smallerAprox = Math.abs(0.5 - ratio);
        boolean diagnoseReady = onlyOneSympton;

        for (int i = 1;i < countSymptons.length;i++) {
            // tem apenas um sintoma para todos os diagnósticos apresentados
            onlyOneSympton = countSymptons[i] == 0 || countSymptons[i] == newLenPossibleDiagnosis;

            ratio = onlyOneSympton ? 0 : (float) countSymptons[i] / newLenPossibleDiagnosis;
            double aprox = Math.abs(0.5 - ratio);

            diagnoseReady &= onlyOneSympton;

            if (aprox < smallerAprox) {
                smallerAprox = aprox;
                nextSympton = i;
            }
        }

        return diagnoseReady ? -1 : nextSympton;
    }

    private String questionFromIndSympton (int indSympton) {
        return "Você está sentindo " + this.symptons[indSympton] + "?";
    }

    private String getBestDiagnosis() {
        Map<String, Integer> dic = new HashMap<String, Integer>();

        for (int i = 0;i < this.lenPossibleDiagnosis;i++) {
            String diagnosis = this.diagnosis[this.possibleDiagnosis[i]][this.symptons.length - 1];
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
        return this.indSymptonToAsk != -1;
    }

    public String nextQuestion () {
        return questionFromIndSympton(this.indSymptonToAsk);
    }

    public void answerQuestion (String answer) {
        try {
            boolean feeling = patientTranslator.sense(answer);
            this.indSymptonToAsk = filterDiagnosisAndCalcNextBest(this.indSymptonToAsk, feeling);
        } catch (Exception e) {
            System.out.println("Erro com NPL");
            e.printStackTrace();
        }
    }

    public String getDiagnosis () {
        return getBestDiagnosis();
    }
}
