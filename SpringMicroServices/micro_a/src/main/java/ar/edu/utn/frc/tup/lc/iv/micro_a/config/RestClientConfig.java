package ar.edu.utn.frc.tup.lc.iv.micro_a.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestClientConfig {
    public static final int TIME_OUT = 1000; //EXPRESADO EN MILISEGUNDOS 1000 = 1;
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       // return new RestTemplate();}
        //PATRON DE DISEÑO BUILDER
        return builder.setConnectTimeout(Duration.ofMillis(TIME_OUT))
                .setReadTimeout(Duration.ofMillis(TIME_OUT)).build();}
}
