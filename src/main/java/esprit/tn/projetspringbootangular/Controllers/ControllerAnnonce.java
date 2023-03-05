package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.*;

import esprit.tn.projetspringbootangular.Services.EmailService;
import esprit.tn.projetspringbootangular.Services.EmailServiceImpl;
import esprit.tn.projetspringbootangular.Services.IserviceAnnonce;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Tag(name = "Web Services pour la gestion du l'annonce avec Swagger")
@RestController
@AllArgsConstructor
@RequestMapping("annonce")

public class ControllerAnnonce {
    private final IserviceAnnonce iserviceAnnonce;
    private final EmailServiceImpl emailService;

    /*private final Logger logger = LogManager.getLogger(ControllerAnnonce.class);*/

    @Operation(description = "ceci pour l'ajout de l'annonce mobilité")
    @PostMapping("/addAnnonceMobilte")
    public void ajouterAnnonce(@RequestBody AnnonceMobilte annonce ){
        this.iserviceAnnonce.ajouterAnnonce(annonce);
        emailService.sendSimpleEmail("nouha.kouki@esprit.tn", "annonce ajouter ", "verifier annonce ajouter");

    }
    @GetMapping("/getSentimentScoreForAnnonce")
    public double getSentimentScoreForAllAnnonces(){
        return iserviceAnnonce.getSentimentScoreForAllAnnonces();
    }

   /* @GetMapping("/trouverconmmentbyidannonce/{id}")
    public   List<CommentAnnonce> trouverconmmentbyidannonce(@PathVariable("id")  Integer id_Annonce){
        return  iserviceAnnonce.trouverconmmentbyidannonce(id_Annonce);}*/





    @Operation(description = "ceci pour l'affichage de la liste des annonce mobilité")
    @GetMapping("/GetAnnonceMobilte")
    public List<AnnonceMobilte> afficherAnnonces() {

        return iserviceAnnonce.afficherAnnonces();
    }


    @Operation(description = "ceci pour l'affichage de la liste des annonce mobilité avec leur identifiant")
    @GetMapping("/GetAnnonceMobiltebyId/{id}")
    public AnnonceMobilte afficherAnnonceavecid(@PathVariable("id") Integer id_Annonce) {
        return iserviceAnnonce.afficherAnnonceavecid(id_Annonce);
    }


    @Operation(description = "ceci pour la modification de la liste des annonce mobilité avec leur identifiant")
    @PostMapping("/UpdateAnnonceMobiltebyId/{id}")
    public AnnonceMobilte modifierAnnonce(@PathVariable("id") Integer id_Annonce, AnnonceMobilte annonceModifiee) {
        return iserviceAnnonce.modifierAnnonce(id_Annonce, annonceModifiee);

    }

    @Operation(description = "ceci pour la supprission d'annonce")
    @DeleteMapping("/Delete annoonce/{id}")
    public void supprimerAnnonceMobilte(@PathVariable("id") Integer id_Annonce) {
        iserviceAnnonce.supprimerAnnonceMobilte(id_Annonce);
    }






    /**********Hebergement***************************************************************************************/






    @Operation(description = "ceci pour l'ajout de l'annonce Hebergement")
    @PostMapping("/addAnnoncehebergement")
    public AnnonceHeberge ajouterAnnonceH( AnnonceHeberge annonceHeberge ) {
        return     iserviceAnnonce.ajouterAnnonceH(annonceHeberge);

    }






    @Operation(description = "ceci pour l'affichage de la liste des annonce Hebergement")
    @GetMapping("/Get_Annonce_hebergement")
    public List<AnnonceHeberge> afficherAnnonceH() {

        return iserviceAnnonce.afficherAnnonceH();
    }


    @Operation(description = "ceci pour l'affichage de la liste des annonce hebergement avec leur identifiant")
    @GetMapping("/Get_Annonce_hebergement_byId/{id}")
    public AnnonceHeberge afficherAnHebergementeavecid(@PathVariable("id") Integer id_AnnHeb) {
        return iserviceAnnonce.afficherAnHebergementeavecid(id_AnnHeb);
    }


    @Operation(description = "ceci pour la modification de la liste des annonce mobilité avec leur identifiant")
    @PostMapping("/Update_AnnonceHebergement/{id}")
    public AnnonceHeberge modifierAnnonceHeb(@PathVariable("id") Integer id_AnnHeb, AnnonceHeberge annonceHmodifier) {
        return iserviceAnnonce.modifierAnnonceHeb(id_AnnHeb, annonceHmodifier);

    }

    @Operation(description = "ceci pour la supprission d'annonce hebergement")
    @DeleteMapping("/Delete annoonce_hebergement/{id}")
    public void supprimerAnnoncehebergement(@PathVariable("id") Integer id_AnnHeb) {
        iserviceAnnonce.supprimerAnnoncehebergement(id_AnnHeb);
    }






    /******************************ControllerComent***************************************************************/






    @Operation(description = "ceci pour ajouter Commentaire ")
    @PostMapping("/ajouterCommentaire/{id}")
    public void ajouterCommentaire(@RequestBody CommentAnnonce commentAnnonce, @PathVariable("id")Integer id_Annonce){
        iserviceAnnonce.ajouterCommentaire(commentAnnonce,id_Annonce );}







    @Operation(description = "ceci pour l'affichage de la liste Comentaire")
    @GetMapping("/afficherComment")
    public List<CommentAnnonce> afficherComment(){
        return  iserviceAnnonce.afficherComment();}

    @Operation(description = "ceci pour la modification Commentaire")
    @PostMapping("/modifierComment/{id}")
    public CommentAnnonce modifierComment(@PathVariable("id") Integer idCommentaire, CommentAnnonce commentAnnonce){
        return  iserviceAnnonce.modifierComment(idCommentaire,commentAnnonce);}

    @Operation(description = "ceci pour la supprission dun commentaire")
    @DeleteMapping("/supprimerCommentAnnonce/{id}")
    public void supprimerCommentAnnonce(@PathVariable("id")Integer idCommentaire) {
        iserviceAnnonce.supprimerCommentAnnonce(idCommentaire);}


    @PutMapping("/affecterAnnonceToComment/{idCommentaire}/{id_Annonce}")
    public void affecterAnnonceToComment(@PathVariable("idCommentaire") Integer idCommentaire,@PathVariable("id_Annonce") Integer id_Annonce){
        iserviceAnnonce.affecterAnnonceToComment(idCommentaire,id_Annonce);}



    @PutMapping("/affecterUserToComment/{idCommentaire}/{id_user}")
    public void affecterUserToComment(@PathVariable("idCommentaire")Integer idCommentaire,@PathVariable("id_user") Long id_user){
        iserviceAnnonce.affecterUserToComment(idCommentaire,id_user);}


    /***********************DetailsMobilte***************************************************************************/



    @Operation(description = "ceci pour ajouter Details Mobilite ")
    @PostMapping("/ajouterDetailsMobilite/{id}")
    public void ajouterDetailsMobilite(@RequestBody DetailMobilte detailMobilte ,@PathVariable("id") Integer id_Annonce){

        iserviceAnnonce.ajouterDetailsMobilite(detailMobilte,id_Annonce);
    }



    @Operation(description = "ceci pour afficher Detail Mobilte")
    @GetMapping("/afficherDetailMobilte")
    public List<DetailMobilte> afficherDetailMobilte(){
        return  iserviceAnnonce.afficherDetailMobilte();}

    @Operation(description = "ceci pour l'affichage afficher Detail MobilteAvecid avec son identifiant")
    @GetMapping("/afficherDetailMobilteAvecid/{idD}")
    public DetailMobilte afficherDetailMobilteAvecid(@PathVariable("idD")  Integer id_det){
        return  iserviceAnnonce.afficherDetailMobilteAvecid(id_det);}



    @Operation(description = "ceci pour modifier DetailMobilte")
    @PostMapping("/modifierDetailMobilte/{idD}")
    public DetailMobilte modifierDetailMobilte(@PathVariable("idD") Integer id_det, DetailMobilte detailModifiee){
        return iserviceAnnonce.modifierDetailMobilte(id_det,detailModifiee);}

    @Operation(description = "ceci pour  supprimer Detail Mobilte")
    @DeleteMapping("/supprimerDetailMobilte/{iddet}")
    public void supprimerDetailMobilte(@PathVariable("iddet") Integer id_det){
        iserviceAnnonce.supprimerDetailMobilte(id_det);}

    @PutMapping("/affecterDetailsMobiliteToAnnonce/{id_det}/{id_Annonce}")
    public void affecterDetailsMobiliteToAnnonce(@PathVariable("id_det")Integer id_det,@PathVariable("id_Annonce") Integer id_Annonce){
        iserviceAnnonce.affecterDetailsMobiliteToAnnonce(id_det,id_Annonce);}



    /*******************************DetilsHebergement*******************************************************************/

    @Operation(description = "ceci pour ajouter Detail Hebergement ")
    @PostMapping("/ajouterDetailHebergement")
    public void ajouterDetailHebergement(@RequestBody DetailHebergement detailHebergement){
        iserviceAnnonce.ajouterDetailHebergement(detailHebergement);}


    @Operation(description = "ceci pour afficher Detail Hebergement")
    @GetMapping("/afficherDetailHebergement")
    public List<DetailHebergement> afficherDetailHebergement(){
        return  iserviceAnnonce.afficherDetailHebergement();}

    @Operation(description = "ceci pour modifier DetailHebergement")
    @PostMapping("/modifierDetailHebergement/{idD}")
    public DetailHebergement modifierDetailHebergement(@PathVariable("idD")Integer id_detail, DetailHebergement detailModifiee){
        return iserviceAnnonce.modifierDetailHebergement(id_detail,detailModifiee);}


    @Operation(description = "ceci pour  supprimer Detail hebergement")
    @DeleteMapping("/supprimerDetailHebergement/{idH}")
    public void supprimerDetailHebergement(@PathVariable("idH")Integer id_detail){
        iserviceAnnonce .supprimerDetailHebergement(id_detail);  }



    @PutMapping("/affecterDetailsHebergementToAnnonce/{id_detail}/{id_AnnHeb}")
    public void affecterDetailsHebergementToAnnonce(@PathVariable("id_detail")Integer id_detail, @PathVariable("id_AnnHeb")Integer id_AnnHeb){
        iserviceAnnonce.affecterDetailsHebergementToAnnonce(id_detail,id_AnnHeb);}






    /*************RechercheControlller***********************************************************************************/






    @Operation(description = "ceci pour l'affichage de la liste des annonce par titre")
    @GetMapping("/annonces/titre")
    public List<AnnonceMobilte> chercherAnnoncesParTitre(@RequestParam("titre") String titre) {
        return iserviceAnnonce.chercherAnnoncesParTitre(titre);
    }

    @Operation(description = "ceci pour RechercheAnnonceHebergeByAdresse")
    @GetMapping("/RechercheAnnonceHebergeByAdresse/adresse")
    public List<AnnonceHeberge> RechercheAnnonceHebergeByAdresse(@PathVariable("adresse")  String adresse){
        return  iserviceAnnonce.RechercheAnnonceHebergeByAdresse(adresse);

    }


    @Operation(description = "ceci pour RechercheHebergementparleurdatepublication")
    @GetMapping("/RechercheHebergementparleurdatepublication/datePub")
    public List<AnnonceHeberge> RechercheHebergementparleurdatepublication(@PathVariable("adresse")LocalDate datePub){
        return  iserviceAnnonce.RechercheHebergementparleurdatepublication(datePub);
    }


    @Operation(description = "ceci pour l'affichage de la liste des annonce par titre")
    @GetMapping("/afficherAnnonceParTitre")
    public void afficherAnnonceParTitre(@RequestParam("titre") String titre) {
        iserviceAnnonce.afficherAnnonceParTitre(titre);
    }


    @Operation(description = "ceci pour l'affichage de la liste des annonce par lieu")
    @GetMapping("/afficherAnnonceParlieu/{lieu}")
    public List<AnnonceMobilte> afficherAnnonceParLieu(@PathVariable("lieu") String lieu) {
        return iserviceAnnonce.afficherAnnonceParLieu(lieu);
    }

    @Operation(description = "ceci pour le filtrage  des annonce par categorie")
    @GetMapping("/getAnnoncesByCategorie/{categorie}")
    public List<AnnonceMobilte> getAnnoncesByCategorie(@PathVariable("categorie") CategorieMobilite categorie) {
        return iserviceAnnonce.findByCategorie(categorie);

    }

    @Operation(description = "ceci pour le filtrage  des annonce par datePublication")
    @GetMapping("/getAnnoncesFiltrees/{filter}")
    public List<AnnonceMobilte> getAnnoncesFiltrees(@PathVariable String filter) {
        return iserviceAnnonce.getAnnoncesFiltrees(filter);
    }


    @Operation(description = "supprimerAnnonces qui a une DateLimite expiré")
    @DeleteMapping("/supprimerAnnoncesDateLimite")

    public void supprimerAnnoncesDateLimite() {
        LocalDate aujourdHui = LocalDate.now();
        List<AnnonceMobilte> annonces = iserviceAnnonce.findByDateLimiteInscription(aujourdHui);
        for (AnnonceMobilte annonce : annonces) {
            iserviceAnnonce.delete(annonce);
        }

    }


    /********les affectationdeMobilte*************************************************************************/

    @PutMapping("/affecterUserToAbonnement/{id_user}/{idAbonnement}")
    public void affecterUserToAbonnement(@PathVariable Long id_user, @PathVariable Integer idAbonnement) {
        iserviceAnnonce.affecterUserToAbonnement(id_user, idAbonnement);
    }

    @PutMapping("/affecterAnnonceToAbonnement/{id_Annonce}/{idAbonnement}")
    public void affecterAnnonceToAbonnement(@PathVariable("id_Annonce")Integer id_Annonce,@PathVariable("idAbonnement") Integer idAbonnement) {
        iserviceAnnonce.affecterAnnonceToAbonnement(id_Annonce, idAbonnement);
    }

  /*  @Operation(description = "ceci pour laffectation de lannonce a une unvesité ")
    @PutMapping("/affecterAnnonceMobiliteAUniversity/{idA}/{idU}")
    public void affecterAnnonceMobiliteAUniversity(@PathVariable("idA") Integer id_Annonce, @PathVariable("idU") Long idUniversity) {
        iserviceAnnonce.affecterAnnonceMobiliteAUniversity(id_Annonce, idUniversity);
    }*/


    @Operation(description = "ceci est pour lajout d'une favoris")
    @PostMapping("/ajouterFavoris")
    public FavorisMobile ajouterFavoris(FavorisMobile favorisMobile) {
        return iserviceAnnonce.ajouterFavoris(favorisMobile);
    }




    /****************************les affection hebergement *******************************************/




    @Operation(description = "ceci pour affecter UserToAnnonceHebergement ")
    @PutMapping("/affecterUserToAnnonceHebergement/{id_AnnHeb}/{id_user}")
    public void affecterUserToAnnonceHebergement(@PathVariable("id_AnnHeb")Integer id_AnnHeb,@PathVariable("id_user") Long id_user){
        iserviceAnnonce.affecterUserToAnnonceHebergement(id_AnnHeb,id_user);}

    @Operation(description = "ceci pour affecter University ToAnnonceHebergement ")
    @PutMapping("/affecterUniversityToAnnonceHebergement/{idUniversity}/{id_AnnHeb}")
    public void affecterUniversityToAnnonceHebergement(@PathVariable("idUniversity")Long idUniversity, @PathVariable("id_AnnHeb") Integer id_AnnHeb){
        iserviceAnnonce.affecterUniversityToAnnonceHebergement(idUniversity,id_AnnHeb);}


    @Operation(description = "ceci pour affecterUserToFavorisHebergement")
    @PutMapping("/affecterUserToFavorisHebergement/{id_AnnHeb}/{id_user}")
    public void affecterUserToFavorisHebergement(@PathVariable("id_AnnHeb")Integer id_AnnHeb,@PathVariable("id_user") Long id_user){
        iserviceAnnonce.affecterUserToFavorisHebergement(id_AnnHeb,id_user);
    }

    @Operation(description = "ceci pour affecterUserToFavorisMobilite")
    @PutMapping("/affecterUserToFavorisMobilite/{id_fav}/{id_user}")
    public void affecterUserToFavorisMobilite(@PathVariable("id_fav")Integer id_fav, @PathVariable("id_user")Long id_user){
        iserviceAnnonce.affecterUserToFavorisMobilite(id_fav,id_user);}



  /* @Operation(description = "ceci pour aaffecterUserToFavorisMobilite")
    @PutMapping("/affecterAnnonceMobiliteToFavorisMobilite/{id_fav}/{id_Annonce}")
    public void affecterAnnonceMobiliteToFavorisMobilite(@PathVariable("id_fav") Integer id_fav,@PathVariable("id_Annonce") Integer id_Annonce){
    iserviceAnnonce.affecterAnnonceMobiliteToFavorisMobilite(id_fav,id_Annonce);}*/


   /* @Operation(description = "ceci pour affecterAnnonceHebergementToFavorisHebergemente")
    @PutMapping("/affecterAnnonceHebergementToFavorisHebergement/{id_favHeb}/{id_AnnHeb}")
    public void affecterAnnonceHebergementToFavorisHebergement(@PathVariable("id_favHeb")Integer id_favHeb, @PathVariable("id_AnnHeb") Integer id_AnnHeb){
    iserviceAnnonce.affecterAnnonceHebergementToFavorisHebergement(id_favHeb,id_AnnHeb);
    }*/






    /*********************************abonnementController************************************************/
    @Operation(description = "ceci pour la creation d'un abonnement")
    @PostMapping("/createAbonnement")
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return iserviceAnnonce.createAbonnement(abonnement);
    }

    @GetMapping("/getAbonnementsActifs/{categorie}")
    public List<Abonnement> AFFICHERAbonnementsActifs(@PathVariable("categorie") CategorieMobilite categorie) {
        return iserviceAnnonce.AFFICHERAbonnementsActifs(categorie);
    }

    @Operation(description = "ceci pour la modification d'un abonnement")
    @PutMapping("/UpdateAbonnement/{idA}")
    public Abonnement UpdateAbonnement(Abonnement abonnement, @PathVariable("idA") Integer idAbonnement) {
        return iserviceAnnonce.UpdateAbonnement(abonnement, idAbonnement);
    }

    @Operation(description = "ceci pour la affichage d'un abonnement")
    @GetMapping("/GetAbonnement/{idA}")
    public Abonnement GetAbonnement(@PathVariable("idA") Integer idAbonnement) {
        return iserviceAnnonce.GetAbonnement(idAbonnement);

    }

    @Operation(description = "ceci pour la supprission d'un abonnement")
    @DeleteMapping("/deletAbonnement/{idA}")
    public void deletAbonnement(@PathVariable("idA") Integer idAbonnement) {
        iserviceAnnonce.deletAbonnement(idAbonnement);
    }


    /*************************ajouter une annonce aux favoris***********************************************************/


/*@Operation(description="ceci pour la affichage des favoris par user")
@GetMapping("/{userId}")

public ResponseEntity<List<FavorisMobile>> getFavorisByUser(@PathVariable("userId") Integer id_user) {
    User user = new User();
    user.setId_user(id_user);
    List<FavorisMobile> favoris = iserviceAnnonce.findFavorisMobileByUser(user);
    return ResponseEntity.ok(favoris);
}*/
    @Operation(description = "ceci pour la affichage des favoris ")
    @GetMapping("/getFavorisMobiles")
    public List<FavorisMobile> getFavorisMobiles() {
        return iserviceAnnonce.getFavorisMobiles();

    }

    @Operation(description = "ceci pour ajouter AnnonceAuxFavoris ")
    @PostMapping("/ajouterAnnonceAuxFavoris/{id_Annonce}/{id_user}")
    public void ajouterAnnonceAuxFavoris(@PathVariable("id_Annonce") Integer id_Annonce, @PathVariable("id_user") Long id_user) {

        iserviceAnnonce.ajouterAnnonceAuxFavoris(id_Annonce, id_user);
    }


    @Operation(description = "Obtenir les statistique des annonce ")

    @GetMapping("/statistiques")
    public ResponseEntity<Map<String, Map<String, Integer>>> getAnnoncesStatistiques(
            @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFin) {

        Map<String, Map<String, Integer>> statistiques = iserviceAnnonce.getAnnoncesStatistiques(dateDebut, dateFin);

        return ResponseEntity.ok(statistiques);
    }






    @Operation(description = "Obtenir countCandidaciesByAnnouncementId ")

    @GetMapping("/getCandidaciesByAnnouncementId/{idA}")
    public List<Candidacy> getCandidaciesByAnnonceId(@PathVariable("idA") Integer id_Annonce){
        return iserviceAnnonce.getCandidaciesByAnnonceId(id_Annonce);
    }




    @Operation(description = "ceci pour affecterCondidatureToAnnonce")
    @PutMapping("/affecterCondidatureToAnnonce/{idA}/{idU}")
    public void affecterCondidatureToAnnonce(@PathVariable("idA")Integer id,@PathVariable("idU") Integer id_Annonce){
        iserviceAnnonce.affecterCondidatureToAnnonce(id,id_Annonce);
    }





    @Operation(description = "ceci pour calculateDistance")
    @GetMapping("/calculateDistance/{lat1}/{lon1}/{lat2}/{lon2}")
    public  double calculateDistance(@PathVariable("lat1")double lat1,@PathVariable("lon1") double lon1, @PathVariable("lat2")double lat2,@PathVariable("lon2") double lon2){
        return   iserviceAnnonce.calculateDistance(lat1,lon1,lat2,lon2);
    }


    @Operation(description = "ceci pour afficher le score de lannonce")
    @GetMapping("/calculateScore")
    public double calculateScore(Integer id_Annonce){
        return  iserviceAnnonce.calculateScore(id_Annonce);
    }


    @Operation(description = "ceci pour notifierAbonnese")
    @PostMapping("/notifierAbonnes/{cat}")
    public void notifierAbonnes(@PathVariable("cat") CategorieMobilite categorie ,@RequestBody String message){
        iserviceAnnonce.notifierAbonnes(categorie,message);
    }

    @Operation(description = "ceci pour avoir le nombre totale des condidature de tous les annonces")
    @GetMapping("/getTotalCandidatures")
    public int getTotalCandidatures(){
        return  iserviceAnnonce.getTotalCandidatures();
    }

}











