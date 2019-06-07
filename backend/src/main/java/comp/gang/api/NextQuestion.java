package comp.gang.api;

public class NextQuestion extends GenericResponse{
    private final String question;

    public NextQuestion(String question){
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
