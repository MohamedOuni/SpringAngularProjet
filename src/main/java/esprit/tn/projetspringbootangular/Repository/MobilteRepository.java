package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MobilteRepository extends JpaRepository<AnnonceMobilte, Integer> {
    @Query("SELECT a FROM AnnonceMobilte a WHERE a.titre LIKE %:titre%")
    List<AnnonceMobilte> findAnnonceMobilteByTitreIgnoreCase(@Param("titre") String titre);

}
