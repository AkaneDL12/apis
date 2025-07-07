package IngenieriaWeb.Proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
}
