package comp.gang.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class AnswerQuestionController {

    @RequestMapping("/answerquestion")
    public GenericResponse answerQuestion(@RequestParam(value = "answer", defaultValue = "") String answer) {
        doctor.answerQuestion(answer);
        if(doctor.hasQuestions()) {
            return new NextQuestion(doctor.nextQuestion());
        }else{
            return new Diagnosis(doctor.getDiagnosis());
        }
    }
}
