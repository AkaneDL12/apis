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

import IngenieriaWeb.Proyecto.Model.ImagenProducto;
import IngenieriaWeb.Proyecto.Services.ImagenProductoService;

@RestController
@RequestMapping("/api/imagen-producto")
public class ImagenProductoController {
    @Autowired
    private ImagenProductoService imagenProductoService;

    @GetMapping
    public List<ImagenProducto> getAllImagenesProducto() {
        return imagenProductoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenProducto> getImagenProductoById(@PathVariable Long id) {
        Optional<ImagenProducto> imagenProducto = imagenProductoService.findById(id);
        return imagenProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ImagenProducto createImagenProducto(@RequestBody ImagenProducto imagenProducto) {
        return imagenProductoService.save(imagenProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenProducto> updateImagenProducto(@PathVariable Long id,
            @RequestBody ImagenProducto imagenProductoDetails) {
        Optional<ImagenProducto> imagenProductoOptional = imagenProductoService.findById(id);
        if (imagenProductoOptional.isPresent()) {
            ImagenProducto imagenProducto = imagenProductoOptional.get();
            // Agrega aquí los setters necesarios para actualizar los campos
            return ResponseEntity.ok(imagenProductoService.save(imagenProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagenProducto(@PathVariable Long id) {
        if (imagenProductoService.findById(id).isPresent()) {
            imagenProductoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
