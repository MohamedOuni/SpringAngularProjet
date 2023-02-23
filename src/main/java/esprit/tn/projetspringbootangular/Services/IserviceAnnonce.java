package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Abonnement;
import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Entities.CategorieMobilite;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
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

    void afficherAnnonceParLieu(String lieu);

    List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie);

    List<AnnonceMobilte> getAnnoncesFiltrees(String filter);

    List<AnnonceMobilte> findByDateLimiteInscription(LocalDate dateLimiteInscription);

    @Scheduled(fixedDelay = 3600000) // toutes les heures
    void verifierDateLimiteInscription();

    void delete(AnnonceMobilte annonceMobilte);

    void affecterAnnonceMobiliteAUniversity(Integer id_Annonce, Integer idUniversity);

    AnnonceMobilte ajouterAnnonceMobilteEtAffecterToUniversity(AnnonceMobilte annonceMobilte, Integer idUniversity);

    List<AnnonceMobilte> AfficherListeAnnonceParUniversite(Integer idUniversity);

    //ajouter une unviersité  et affecter a 2 equipe les 2 id doivent etre different
    void ajouterDeuxAnnonceEtAffecterAUniversity(Integer idUniversity, AnnonceMobilte annonceMobilte, AnnonceHeberge annonceHeberge);

    Abonnement createAbonnement(Abonnement abonnement);

    Abonnement UpdateAbonnement(Abonnement abonnement, Integer idAbonnement);

    Abonnement GetAbonnement(Integer idAbonnement);

    void deletAbonnement(Integer idAbonnement);

    List<Abonnement> getAbonnementsActifs(CategorieMobilite categorie);


    String envoyerEmailPourNouvelleAnnonce(CategorieMobilite categorie, String sujet, String message);

    String sendSimpleMail(String recipient, String subject, String message);
}
