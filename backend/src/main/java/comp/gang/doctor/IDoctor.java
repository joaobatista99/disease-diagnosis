package comp.gang.doctor;

public interface IDoctor {
    public boolean hasQuestions();
    public String nextQuestion();
    public void answerQuestion(String answer);
    public String getDiagnosis();
}
