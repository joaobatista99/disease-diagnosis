package comp.gang.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class NextQuestionController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/nextquestion")
    public NextQuestion nextQuestion() {
        return new NextQuestion(doctor.nextQuestion());
    }
}
