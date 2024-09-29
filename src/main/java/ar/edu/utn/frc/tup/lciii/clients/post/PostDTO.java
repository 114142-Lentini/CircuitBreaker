package ar.edu.utn.frc.tup.lciii.clients.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//NOTAS: Se puede hacer clase pero con esto es mas simple
@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDTO(Long id, String title) {

}
