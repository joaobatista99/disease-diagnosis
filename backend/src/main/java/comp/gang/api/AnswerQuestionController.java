package comp.gang.api;

/*import jsmaiorjava.implementations.Prontuario;
import jsmaiorjava.implementations.ZumbiTwittero;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class AnswerQuestionController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/answerquestion")
    public GenericResponse answerQuestion(@RequestParam(value = "answer", defaultValue = "") String answer) {
        doctor.answerQuestion(answer);
        if(doctor.hasQuestions()) {
            return new NextQuestion(doctor.nextQuestion());
        }else{
            String diagnose = doctor.getDiagnosis();

            /*Uso do componente do zumbi twittero*/
            /*ZumbiTwittero zumbiTwittero = new ZumbiTwittero(new Prontuario(diagnose, "Paciente do Hospital CompGang", "Doutor do hospital CompGang"));
            zumbiTwittero.twittar();*/

            return new Diagnosis(diagnose);
        }
    }
}
