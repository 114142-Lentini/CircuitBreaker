package ar.edu.utn.frc.tup.lc.iv.micro_b.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    private Integer counter = 0;
    @GetMapping("/micro")
    public String micro() {
        counter++;
        if(counter > 10 && counter < 30) {
            System.out.println("Call N°: " + counter + " - Error en micro B");
            throw new RuntimeException("Error");
        }
        System.out.println("Call N°: " + counter + " - OK en micro B");
        return "Pong from Micro b - counter = " + counter;
    }
}
