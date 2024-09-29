package ar.edu.utn.frc.tup.lciii.clients.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostRestClient {
    //NOTAS: Esto solo se puede hacer con el restClientConfig
    @Autowired
    RestTemplate restTemplate;
    String baseUrl = "https://my-json-server.typicode.com/114142-Lentini/fake-api/posts";

    public ResponseEntity<PostDTO[]> getPosts() {return restTemplate.getForEntity(baseUrl,PostDTO[].class);}
    public ResponseEntity<PostDTO> getPost(Long id) {return restTemplate.getForEntity(baseUrl + "/" + id,PostDTO.class);}

}
