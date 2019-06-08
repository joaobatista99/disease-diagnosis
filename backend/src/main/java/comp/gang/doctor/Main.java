package comp.gang.doctor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Doctor d = new Doctor();
        Scanner s = new Scanner(System.in);

        while (d.hasQuestions()){
            System.out.println(d.nextQuestion());
            String resposta = s.nextLine();
            d.answerQuestion(resposta);
        }

        System.out.println(d.getDiagnosis());
    }
}
