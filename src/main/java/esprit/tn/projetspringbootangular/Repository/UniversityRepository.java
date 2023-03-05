package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long>  {
}
