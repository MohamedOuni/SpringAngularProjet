package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.DetailHebergement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsHebergementRepository extends JpaRepository<DetailHebergement, Integer> {
}
