package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
