package ar.edu.utn.frc.tup.lc.iv.micro_a.scheduled;

import ar.edu.utn.frc.tup.lc.iv.micro_a.clients.MicroBRestClient;
import ar.edu.utn.frc.tup.lc.iv.micro_a.clients.MicroCRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleMicroB {
    @Autowired
    private MicroBRestClient microBRestClient;
    @Autowired
    private MicroCRestClient microCRestClient;
    //Cada tanto tiempo se ejecuta el método 1000 milisegundos
    @Scheduled(fixedDelay = 1000)
    public void scheduledActionCalledB(){
        try {
            ResponseEntity<String> microResponse = microBRestClient.getMicro();
            System.out.println(microResponse.getBody());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Cada tanto tiempo se ejecuta el método 1000 milisegundos
    @Scheduled(fixedDelay = 1000)
    public void scheduledActionCalledC(){
        try {
            ResponseEntity<String> microResponse = microCRestClient.getMicro();
            System.out.println(microResponse.getBody());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
