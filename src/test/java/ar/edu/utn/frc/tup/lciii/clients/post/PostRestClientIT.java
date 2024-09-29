package ar.edu.utn.frc.tup.lciii.clients.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
//NOTAS: ESTE ES EL TEST DE INTEGRACIÓN DE RESTCLIENT
@SpringBootTest
public class PostRestClientIT {
    @Autowired
     PostRestClient postRestClient;
    @Test
    void getPostsTest(){
        ResponseEntity<PostDTO[]> result = postRestClient.getPosts();
        assertEquals(3, Objects.requireNonNull(result.getBody()).length);
    }
    @Test
    void getPostTest(){
        ResponseEntity<PostDTO> result = postRestClient.getPost(Long.parseLong("1"));
        assertEquals("hello", Objects.requireNonNull(result.getBody()).title());
    }
    
}
