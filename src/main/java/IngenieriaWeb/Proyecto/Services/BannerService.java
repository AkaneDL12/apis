package IngenieriaWeb.Proyecto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IngenieriaWeb.Proyecto.Model.Banner;
import IngenieriaWeb.Proyecto.Repositories.BannerRepository;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    public Optional<Banner> findById(Long id) {
        return bannerRepository.findById(id);
    }

    public Banner save(Banner banner) {
        return bannerRepository.save(banner);
    }

    public void deleteById(Long id) {
        bannerRepository.deleteById(id);
    }
}
