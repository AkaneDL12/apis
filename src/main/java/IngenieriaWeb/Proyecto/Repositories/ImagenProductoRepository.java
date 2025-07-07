package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.ImagenProducto;

@Repository
public interface ImagenProductoRepository extends JpaRepository<ImagenProducto, Long> {
}
