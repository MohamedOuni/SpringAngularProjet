package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Candidacy;
import esprit.tn.projetspringbootangular.Entities.FavorisHebergement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CondidacyRepository extends JpaRepository<Candidacy, Integer> {
    @Query("SELECT c FROM Candidacy c WHERE c.annonceMobilte.id_Annonce = :id_Annonce")
    List<Candidacy> findCandidaciesByAnnonceId(@Param("id_Annonce") Integer id_Annonce);
}
