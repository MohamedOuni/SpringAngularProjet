package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Abonnement;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Entities.FavorisMobile;
import esprit.tn.projetspringbootangular.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavorisMobilteRepository extends JpaRepository<FavorisMobile, Integer> {
  /*  @Query("SELECT f FROM FavorisMobile f WHERE f.user = :user")
    List<FavorisMobile> findFavorisMobileByUser(@Param("user") User user);*/


    FavorisMobile findByUserAndAnnonceMobiltes(User user, AnnonceMobilte annonce);
}
