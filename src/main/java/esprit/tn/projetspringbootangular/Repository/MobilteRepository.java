package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Entities.CategorieMobilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MobilteRepository extends JpaRepository<AnnonceMobilte, Integer> {
    @Query("SELECT a FROM AnnonceMobilte a WHERE a.titre LIKE %:titre%")
    List<AnnonceMobilte> findAnnonceMobilteByTitreIgnoreCase(@Param("titre") String titre);
    @Query("SELECT a FROM AnnonceMobilte a WHERE a.lieu LIKE %:lieu%")
    List<AnnonceMobilte> findAnnonceMobilteByLieuIgnoreCase(@Param("lieu") String lieu);
    List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie);
    List<AnnonceMobilte> findAnnonceMobilteByDatePublicationnAfter(LocalDate datePublicationn);



    @Query("select a from AnnonceMobilte a where a.dateLimiteInsription = :date")
    List<AnnonceMobilte> findByDateLimiteInscription(@Param("date") LocalDate date);

    void delete(AnnonceMobilte annonce);
}
