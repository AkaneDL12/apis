package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
