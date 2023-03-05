package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IserviceAnnonce {




    void affecterUserToComment(Integer idCommentaire, Long id_user);




    void ajouterAnnonce(AnnonceMobilte annonce);




    void filterCommentwithInappropriateContents(CommentAnnonce commentAnnonce);

    void filterCommentwithInappropriateContentstoAnnonce(AnnonceMobilte annonceMobilte);

    List<AnnonceMobilte> afficherAnnonces();


    void ajouterDetailsMobilite(DetailMobilte detailMobilte, Integer id_Annonce);

    List<DetailMobilte> afficherDetailMobilte();

    AnnonceMobilte afficherAnnonceavecid(Integer id_Annonce);

    DetailMobilte afficherDetailMobilteAvecid(Integer id_det);

    AnnonceMobilte modifierAnnonce(Integer id_Annonce, AnnonceMobilte annonceModifiee);

    void supprimerAnnonceMobilte(Integer id_Annonce);




    AnnonceHeberge ajouterAnnonceH(AnnonceHeberge anhebergement);

    List<AnnonceHeberge> afficherAnnonceH();

    AnnonceHeberge afficherAnHebergementeavecid(Integer id_AnnHeb);

    AnnonceHeberge modifierAnnonceHeb(Integer id_AnnHeb, AnnonceHeberge annonceHmodifier);

    void supprimerAnnoncehebergement(Integer id_AnnHeb);

    List<AnnonceMobilte> chercherAnnoncesParTitre(String titre);

    List<AnnonceHeberge> RechercheAnnonceHebergeByAdresse(String adresse);

    List<AnnonceHeberge> RechercheHebergementparleurdatepublication(LocalDate datePub);

    void afficherAnnonceParTitre(String titre);

    List<AnnonceMobilte> afficherAnnonceParLieu(String lieu);

    List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie);



    List<AnnonceMobilte> getAnnoncesFiltrees(String filter);

    void delete(AnnonceMobilte annonceMobilte);

    List<AnnonceMobilte> findByDateLimiteInscription(LocalDate dateLimiteInscription);

    @Scheduled(cron = "0 0 0 * * *") // chaque jour à minuit
    void verifierDateLimiteInscription();



    Abonnement createAbonnement(Abonnement abonnement);

    Abonnement UpdateAbonnement(Abonnement abonnement, Integer idAbonnement);

    Abonnement GetAbonnement(Integer idAbonnement);

    void deletAbonnement(Integer idAbonnement);

    void affecterUserToAbonnement(Long id_user, Integer idAbonnement);

    void affecterAnnonceToAbonnement(Integer id_Annonce, Integer idAbonnement);

    List<Abonnement> AFFICHERAbonnementsActifs(CategorieMobilite categorie);

    FavorisMobile ajouterFavoris(FavorisMobile favorisMobile);

    List<FavorisMobile> getFavorisMobiles();



    void ajouterAnnonceAuxFavoris(Integer id_Annonce, Long id_user);

    Map<String, Map<String, Integer>> getAnnoncesStatistiques(LocalDate dateDebut, LocalDate dateFin);

    List<Candidacy> getCandidaciesByAnnonceId(Integer id_Annonce);

    void affecterCondidatureToAnnonce(Integer id, Integer id_Annonce);

    double calculateDistance(double lat1, double lon1, double lat2, double lon2);

    double calculateScore(Integer id_Annonce);

    void notifierAbonnes(CategorieMobilite categorie, String message);

    int getTotalCandidatures();








/****************************Comment*****************************************/
    void ajouterCommentaire(CommentAnnonce commentAnnonce, Integer id_Annonce);

    List<CommentAnnonce> afficherComment();



    CommentAnnonce modifierComment(Integer idCommentaire, CommentAnnonce commentAnnonce);

    void supprimerCommentAnnonce(Integer idCommentaire);


    DetailMobilte modifierDetailMobilte(Integer id_det, DetailMobilte detailModifiee);

    void supprimerDetailMobilte(Integer id_det);



















    /******************************************Details*******************************************************/
    void ajouterDetailHebergement(DetailHebergement detailHebergement);

    List<DetailHebergement> afficherDetailHebergement();

    DetailHebergement modifierDetailHebergement(Integer id_detail, DetailHebergement detailModifiee);

    void supprimerDetailHebergement(Integer id_detail);






    /*********************affectetion*****************************************************************/

    void affecterAnnonceToComment(Integer idCommentaire, Integer id_Annonce);

    void affecterDetailsMobiliteToAnnonce(Integer id_det, Integer id_Annonce);

    void affecterDetailsHebergementToAnnonce(Integer id_detail, Integer id_AnnHeb);

    void affecterUserToAnnonceHebergement(Integer id_AnnHeb, Long id_user);

    void affecterUniversityToAnnonceHebergement(Long idUniversity, Integer id_AnnHeb);

    void affecterUserToFavorisHebergement(Integer id_AnnHeb, Long id_user);

    void affecterUserToFavorisMobilite(Integer id_fav, Long id_user);



















    /******************score*************************************************************************************************/


    double getSentimentScoreForAllAnnonces();
}