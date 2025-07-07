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

import IngenieriaWeb.Proyecto.Model.Banner;
import IngenieriaWeb.Proyecto.Services.BannerService;

@RestController
@RequestMapping("/api/banners")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping
    public List<Banner> getAllBanners() {
        return bannerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banner> getBannerById(@PathVariable Long id) {
        Optional<Banner> banner = bannerService.findById(id);
        return banner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Banner createBanner(@RequestBody Banner banner) {
        return bannerService.save(banner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banner> updateBanner(@PathVariable Long id, @RequestBody Banner bannerDetails) {
        Optional<Banner> bannerOptional = bannerService.findById(id);
        if (bannerOptional.isPresent()) {
            Banner banner = bannerOptional.get();
            banner.setTitulo(bannerDetails.getTitulo());
            banner.setImagenUrl(bannerDetails.getImagenUrl());
            // Si hay más campos, agregarlos aquí
            return ResponseEntity.ok(bannerService.save(banner));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanner(@PathVariable Long id) {
        if (bannerService.findById(id).isPresent()) {
            bannerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
