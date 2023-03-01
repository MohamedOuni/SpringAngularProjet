package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Abonnement;
import esprit.tn.projetspringbootangular.Entities.FavorisHebergement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorisHebRepository extends JpaRepository<FavorisHebergement, Integer> {
}
