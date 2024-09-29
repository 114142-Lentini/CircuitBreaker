package ar.edu.utn.frc.tup.lciii.clients.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfileRestClientIT {
    @Autowired
    private ProfileRestClient profileRestClient;
    @Test
    void getProfileTest(){
        ResponseEntity<ProfileDTO> result = profileRestClient.getProfile();
        assertEquals("typicode", Objects.requireNonNull(result.getBody()).name());
    }
}
