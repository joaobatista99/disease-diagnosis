package comp.gang.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class NextQuestionController {

    @RequestMapping("/nextquestion")
    public NextQuestion nextQuestion() {
        return new NextQuestion(doctor.nextQuestion());
    }
}
