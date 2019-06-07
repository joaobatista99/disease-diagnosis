package comp.gang.api;

public class Diagnosis extends GenericResponse{
    private final String diagnosis;
    public Diagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
