package IngenieriaWeb.Proyecto.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IngenieriaWeb.Proyecto.Model.ImagenPersona;
import IngenieriaWeb.Proyecto.Services.ImagenPersonaService;

@RestController
@RequestMapping("/api/imagen-persona")
public class ImagenPersonaController {
    @Autowired
    private ImagenPersonaService imagenPersonaService;

    @GetMapping
    public List<ImagenPersona> getAllImagenesPersona() {
        return imagenPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenPersona> getImagenPersonaById(@PathVariable Long id) {
        Optional<ImagenPersona> imagenPersona = imagenPersonaService.findById(id);
        return imagenPersona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ImagenPersona createImagenPersona(@RequestBody ImagenPersona imagenPersona) {
        return imagenPersonaService.save(imagenPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenPersona> updateImagenPersona(@PathVariable Long id,
            @RequestBody ImagenPersona imagenPersonaDetails) {
        Optional<ImagenPersona> imagenPersonaOptional = imagenPersonaService.findById(id);
        if (imagenPersonaOptional.isPresent()) {
            ImagenPersona imagenPersona = imagenPersonaOptional.get();
            // Agrega aquí los setters necesarios para actualizar los campos
            return ResponseEntity.ok(imagenPersonaService.save(imagenPersona));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagenPersona(@PathVariable Long id) {
        if (imagenPersonaService.findById(id).isPresent()) {
            imagenPersonaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
