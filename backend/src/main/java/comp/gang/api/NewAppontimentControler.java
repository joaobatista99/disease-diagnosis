package comp.gang.api;

import comp.gang.doctor.Doctor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class NewAppontimentControler {

    @RequestMapping("/newappointment")
    public GenericResponse newAppontiment() {
        doctor = new Doctor();
        return new NextQuestion(doctor.nextQuestion());
    }
}
