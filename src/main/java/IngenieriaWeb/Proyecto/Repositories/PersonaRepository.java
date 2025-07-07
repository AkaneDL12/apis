package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
