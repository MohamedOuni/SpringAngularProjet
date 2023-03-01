package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IserviceAnnonce {


    void ajouterAnnonce(AnnonceMobilte annonce);

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

    List<AnnonceMobilte> afficherAnnonceParLieu(String lieu);

    List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie);

    List<AnnonceMobilte> getAnnoncesFiltrees(String filter);

    List<AnnonceMobilte> findByDateLimiteInscription(LocalDate dateLimiteInscription);

    @Scheduled(fixedDelay = 3600000) // toutes les heures
    void verifierDateLimiteInscription();

    void delete(AnnonceMobilte annonceMobilte);

    void affecterAnnonceMobiliteAUniversity(Integer id_Annonce, Integer idUniversity);







    Abonnement createAbonnement(Abonnement abonnement);

    Abonnement UpdateAbonnement(Abonnement abonnement, Integer idAbonnement);

    Abonnement GetAbonnement(Integer idAbonnement);

    void deletAbonnement(Integer idAbonnement);

    void affecterAnnonceToAbonnement(Integer id_Annonce, Integer idAbonnement);










    void affecterUserToAbonnement(Integer id_user, Integer idAbonnement);

    List<Abonnement> AFFICHERAbonnementsActifs(CategorieMobilite categorie);

    FavorisMobile ajouterFavoris(FavorisMobile favorisMobile);



    List<FavorisMobile> getFavorisMobiles();

   /* List<FavorisMobile> findFavorisMobileByUser(User user);*/

    void ajouterAnnonceAuxFavoris(Integer annonceId, Integer id_user);

    Map<String, Map<String, Integer>> getAnnoncesStatistiques(LocalDate dateDebut, LocalDate dateFin);






    List<Candidacy> getCandidaciesByAnnonceId(Integer id_Annonce);

    void affecterCondidatureToAnnonce(Integer id, Integer id_Annonce);

    double calculateDistance(double lat1, double lon1, double lat2, double lon2);



    double calculateScore(Integer id_Annonce);

    void notifierAbonnes(CategorieMobilite categorie, String message);
}
