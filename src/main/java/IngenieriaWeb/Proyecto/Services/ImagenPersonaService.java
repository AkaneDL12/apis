package IngenieriaWeb.Proyecto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IngenieriaWeb.Proyecto.Model.ImagenPersona;
import IngenieriaWeb.Proyecto.Repositories.ImagenPersonaRepository;

@Service
public class ImagenPersonaService {
    @Autowired
    private ImagenPersonaRepository imagenPersonaRepository;

    public List<ImagenPersona> findAll() {
        return imagenPersonaRepository.findAll();
    }

    public Optional<ImagenPersona> findById(Long id) {
        return imagenPersonaRepository.findById(id);
    }

    public ImagenPersona save(ImagenPersona imagenPersona) {
        return imagenPersonaRepository.save(imagenPersona);
    }

    public void deleteById(Long id) {
        imagenPersonaRepository.deleteById(id);
    }
}
