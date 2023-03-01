package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Abonnement;
import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.CategorieMobilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {

    @Query("SELECT a FROM Abonnement a WHERE a.categorie = :categorie AND a.actif = true")
    List<Abonnement> findAbonnementsActifsByCategorie(@Param("categorie") CategorieMobilite categorie);

    List<Abonnement> findByCategorieAndActifIsTrue(CategorieMobilite categorie);



}
