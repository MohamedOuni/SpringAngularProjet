package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;

import java.util.List;

public interface IserviceAnnonce {
    AnnonceMobilte ajouterAnnonce(AnnonceMobilte annonce);

    List<AnnonceMobilte> afficherAnnonces();

    AnnonceMobilte afficherAnnonceavecid(Integer id_Annonce);

    AnnonceMobilte modifierAnnonce(Integer id_Annonce, AnnonceMobilte annonceModifiee);

    void supprimerAnnonceMobilte(Integer id_Annonce);





    /*******hebergement*****/


    AnnonceHeberge ajouterAnnonceH(AnnonceHeberge anhebergement);

    List<AnnonceHeberge> afficherAnnonceH();

    AnnonceHeberge afficherAnHebergementeavecid(Integer id_AnnHeb);

    AnnonceHeberge modifierAnnonceHeb(Integer id_AnnHeb, AnnonceHeberge annonceHmodifier);

    void supprimerAnnoncehebergement(Integer id_AnnHeb);


    List<AnnonceMobilte> chercherAnnoncesParTitre(String titre);

    void afficherAnnonceParTitre(String titre);
}
