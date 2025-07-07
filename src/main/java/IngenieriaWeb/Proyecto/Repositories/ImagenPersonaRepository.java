package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.ImagenPersona;

@Repository
public interface ImagenPersonaRepository extends JpaRepository<ImagenPersona, Long> {
}
