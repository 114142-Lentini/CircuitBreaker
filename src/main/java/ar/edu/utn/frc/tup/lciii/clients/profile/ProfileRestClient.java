package ar.edu.utn.frc.tup.lciii.clients.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileRestClient {
    @Autowired
    private RestTemplate restTemplate;
    String baseUrl = "https://my-json-server.typicode.com/114142-Lentini/fake-api/profile";
    public ResponseEntity<ProfileDTO> getProfile(){
        return restTemplate.getForEntity(baseUrl,ProfileDTO.class);
    }
}
