package IngenieriaWeb.Proyecto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IngenieriaWeb.Proyecto.Model.ImagenProducto;
import IngenieriaWeb.Proyecto.Repositories.ImagenProductoRepository;

@Service
public class ImagenProductoService {
    @Autowired
    private ImagenProductoRepository imagenProductoRepository;

    public List<ImagenProducto> findAll() {
        return imagenProductoRepository.findAll();
    }

    public Optional<ImagenProducto> findById(Long id) {
        return imagenProductoRepository.findById(id);
    }

    public ImagenProducto save(ImagenProducto imagenProducto) {
        return imagenProductoRepository.save(imagenProducto);
    }

    public void deleteById(Long id) {
        imagenProductoRepository.deleteById(id);
    }
}
