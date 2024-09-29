package ar.edu.utn.frc.tup.lciii.clients.post;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
//NOTAS: ESTO ES EL TEST UNITARIO DEL RESTCLIENT
@SpringBootTest
public class PostRestClientTest {
    @MockBean
    private RestTemplate restTemplate;
    @SpyBean
    private PostRestClient postRestClient;
    @Test
    void getPostsTest(){
        PostDTO postDTO = new PostDTO(10L, "Test Unitario");
        PostDTO postDTO2 = new PostDTO(11L, "Test de Integracion");
        PostDTO[] postDTOS = {postDTO, postDTO2};
        when(restTemplate.getForEntity("https://my-json-server.typicode.com/114142-Lentini/fake-api/posts", PostDTO[].class))
                .thenReturn(ResponseEntity.ok(postDTOS));
        ResponseEntity<PostDTO[]> result = restTemplate.getForEntity("https://my-json-server.typicode.com/114142-Lentini/fake-api/posts", PostDTO[].class);
        assertEquals(2, Objects.requireNonNull(result.getBody()).length);
    }
    @Test
    void getPostsListTest(){
        PostDTO postDTO = new PostDTO(1L, "Test");
        when(restTemplate.getForEntity("https://my-json-server.typicode.com/114142-Lentini/fake-api/posts/10",PostDTO.class))
                .thenReturn(ResponseEntity.ok(postDTO));
        assertNotNull(restTemplate.getForEntity("https://my-json-server.typicode.com/114142-Lentini/fake-api/posts/10",PostDTO.class));
    }
}
