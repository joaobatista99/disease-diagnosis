package comp.gang.api;

import comp.gang.doctor.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    static Doctor doctor = new Doctor();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}