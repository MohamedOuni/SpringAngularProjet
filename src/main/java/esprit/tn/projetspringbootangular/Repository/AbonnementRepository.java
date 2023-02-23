package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Abonnement;
import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.CategorieMobilite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {
    List<Abonnement> findAbonnementByCategorieAndActifTrue (CategorieMobilite categorie);
}
