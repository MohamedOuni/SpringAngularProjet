package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.DetailMobilte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsMobiliteRepository extends JpaRepository<DetailMobilte, Integer> {
}
