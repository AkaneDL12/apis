package IngenieriaWeb.Proyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngenieriaWeb.Proyecto.Model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
}
