package comp.gang.api;

import comp.gang.doctor.Doctor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static comp.gang.api.Application.*;

@RestController
public class NewAppontimentControler {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/newappointment")
    public GenericResponse newAppontiment() {
        doctor = new Doctor();
        return new NextQuestion(doctor.nextQuestion());
    }
}
