package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.*;
import esprit.tn.projetspringbootangular.Services.EmailService;
import esprit.tn.projetspringbootangular.Services.IserviceAnnonce;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Web Services pour la gestion du l'annonce avec Swagger")
@RestController
@AllArgsConstructor
public class ControllerAnnonce {
    private final IserviceAnnonce iserviceAnnonce;
    private final EmailService emailService;

    @Operation(description="ceci pour l'ajout de l'annonce mobilité")
    @PostMapping("/addAnnonceMobilte")
    public AnnonceMobilte ajouterAnnonce(@RequestBody AnnonceMobilte annonce){
        return iserviceAnnonce.ajouterAnnonce(annonce);}



    @Operation(description="ceci pour l'affichage de la liste des annonce mobilité")
    @GetMapping("/GetAnnonceMobilte")
    public List<AnnonceMobilte> afficherAnnonces(){

        return  iserviceAnnonce.afficherAnnonces();}


    @Operation(description="ceci pour l'affichage de la liste des annonce mobilité avec leur identifiant")
    @GetMapping("/GetAnnonceMobiltebyId/{id}")
    public AnnonceMobilte afficherAnnonceavecid(@PathVariable("id") Integer id_Annonce){
        return  iserviceAnnonce.afficherAnnonceavecid(id_Annonce);
    }


    @Operation(description="ceci pour la modification de la liste des annonce mobilité avec leur identifiant")
    @PostMapping("/UpdateAnnonceMobiltebyId/{id}")
    public AnnonceMobilte modifierAnnonce(@PathVariable("id")Integer id_Annonce, AnnonceMobilte annonceModifiee) {
        return  iserviceAnnonce.modifierAnnonce(id_Annonce,annonceModifiee);

    }
    @Operation(description="ceci pour la supprission d'annonce")
    @DeleteMapping("/Delete annoonce/{id}")
    public void supprimerAnnonceMobilte(@PathVariable("id") Integer id_Annonce){
        iserviceAnnonce.supprimerAnnonceMobilte(id_Annonce);
    }
    /**********Hebergement*************************************************************************/



    @Operation(description="ceci pour l'ajout de l'annonce Hebergement")
    @PostMapping("/addAnnoncehebergement")
    public AnnonceHeberge ajouterAnnonceH(@RequestBody AnnonceHeberge anhebergement){
        return iserviceAnnonce.ajouterAnnonceH(anhebergement);}



    @Operation(description="ceci pour l'affichage de la liste des annonce Hebergement")
    @GetMapping("/Get_Annonce_hebergement")
    public List<AnnonceHeberge> afficherAnnonceH(){

        return  iserviceAnnonce.afficherAnnonceH();
    }


    @Operation(description="ceci pour l'affichage de la liste des annonce hebergement avec leur identifiant")
    @GetMapping("/Get_Annonce_hebergement_byId/{id}")
    public AnnonceHeberge afficherAnHebergementeavecid(@PathVariable("id") Integer id_AnnHeb){
        return  iserviceAnnonce.afficherAnHebergementeavecid(id_AnnHeb);
    }


    @Operation(description="ceci pour la modification de la liste des annonce mobilité avec leur identifiant")
    @PostMapping("/Update_AnnonceHebergement/{id}")
    public AnnonceHeberge modifierAnnonceHeb(@PathVariable("id")Integer id_AnnHeb, AnnonceHeberge annonceHmodifier) {
        return  iserviceAnnonce.modifierAnnonceHeb(id_AnnHeb,annonceHmodifier);

    }
    @Operation(description="ceci pour la supprission d'annonce hebergement")
    @DeleteMapping("/Delete annoonce_hebergement/{id}")
    public void supprimerAnnoncehebergement(@PathVariable("id") Integer id_AnnHeb){
        iserviceAnnonce.supprimerAnnoncehebergement(id_AnnHeb);
    }
    /**********RechercheControlller*****************/
    @Operation(description="ceci pour l'affichage de la liste des annonce par titre")
    @GetMapping("/annonces")
    public List<AnnonceMobilte> chercherAnnoncesParTitre(@RequestParam("titre") String titre) {
        return iserviceAnnonce.chercherAnnoncesParTitre(titre);
    }

    @Operation(description="ceci pour l'affichage de la liste des annonce par titre")
    @GetMapping("/afficherAnnonceParTitre")
    public void afficherAnnonceParTitre(@RequestParam("titre")String titre){
        iserviceAnnonce.afficherAnnonceParTitre(titre);
    }


    @Operation(description="ceci pour l'affichage de la liste des annonce par lieu")
    @GetMapping("/afficherAnnonceParlieu")
    public void afficherAnnonceParLieu(@RequestParam("lieu")String lieu){
        iserviceAnnonce.afficherAnnonceParTitre(lieu);
    }
    @Operation(description="ceci pour le filtrage  des annonce par categorie")
    @GetMapping("/categorie/{categorie}")
    public List<AnnonceMobilte> getAnnoncesByCategorie(@PathVariable("categorie") CategorieMobilite categorie) {
       return   iserviceAnnonce.findByCategorie(categorie);

    }
    @Operation(description="ceci pour le filtrage  des annonce par datePublication")
    @GetMapping("/annonces/{filter}")
    public List<AnnonceMobilte> getAnnoncesFiltrees(@PathVariable String filter) {
        return iserviceAnnonce.getAnnoncesFiltrees(filter);
    }


    @Operation(description="supprimerAnnonces qui a une DateLimite expiré")
    @DeleteMapping("/supprimerAnnoncesDateLimite")

    public void supprimerAnnoncesDateLimite() {
        LocalDate aujourdHui = LocalDate.now();
        List<AnnonceMobilte> annonces = iserviceAnnonce.findByDateLimiteInscription(aujourdHui);
        for (AnnonceMobilte annonce : annonces) {
            iserviceAnnonce.delete(annonce);
        }

}



/********les affectationdeMobilte***************************/




@Operation(description="ceci pour laffectation de lannonce a une unvesité ")
@PutMapping("/affecterAnnonceMobiliteAUniversity/{idA}/{idU}")
public void affecterAnnonceMobiliteAUniversity(@PathVariable("idA")Integer id_Annonce,@PathVariable("idU")   Integer idUniversity){
    iserviceAnnonce.affecterAnnonceMobiliteAUniversity(id_Annonce,idUniversity);
}

    @Operation(description="ceci pour l'jout d'une annonce et affecter a une  université")
    @PostMapping("/ajouterAnnonceMobilteEtAffecterToUniversity/{idU}")


    public AnnonceMobilte ajouterAnnonceMobilteEtAffecterToUniversity(@RequestBody  AnnonceMobilte annonceMobilte, @PathVariable("idU") Integer idUniversity){
    return  iserviceAnnonce.ajouterAnnonceMobilteEtAffecterToUniversity(annonceMobilte,idUniversity);
    }

    @Operation(description="ceci pour l'jout d'une annonce et affecter a une  université")
    @PostMapping("/AfficherListeAnnonceParUniversite/{idU}")
    public List<AnnonceMobilte> AfficherListeAnnonceParUniversite(Integer idUniversity){
    return  iserviceAnnonce.AfficherListeAnnonceParUniversite(idUniversity);
    }


    @Operation(description="ceci pour ajouter Deux Annonce Et Affecter A University")
    @PostMapping("/ajouterDeuxAnnonceEtAffecterAUniversity/{idU}")
    public void ajouterDeuxAnnonceEtAffecterAUniversity(@PathVariable("idU")Integer idUniversity,@RequestBody AnnonceMobilte annonceMobilte, @RequestBody AnnonceHeberge annonceHeberge){
    iserviceAnnonce.ajouterDeuxAnnonceEtAffecterAUniversity(idUniversity,annonceMobilte,annonceHeberge);
    }
/*********************************abonnementController************************************************/
@Operation(description="ceci pour la creation d'un abonnement")
@PostMapping("/createAbonnement")
public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
    return iserviceAnnonce.createAbonnement(abonnement);
}

    @GetMapping("/getAbonnementsActifs/{categorie}")
    public List<Abonnement> getAbonnementsActifs(@PathVariable("categorie") CategorieMobilite categorie) {
        return iserviceAnnonce.getAbonnementsActifs(categorie);
    }
    @Operation(description="ceci pour la modification d'un abonnement")
    @PutMapping("/UpdateAbonnement/{idA}")
    public Abonnement UpdateAbonnement(Abonnement abonnement,@PathVariable("idA") Integer idAbonnement){
    return  iserviceAnnonce.UpdateAbonnement(abonnement,idAbonnement);
    }
    @Operation(description="ceci pour la affichage d'un abonnement")
    @GetMapping("/GetAbonnement/{idA}")
    public Abonnement GetAbonnement(@PathVariable("idA")Integer idAbonnement) {
    return  iserviceAnnonce.GetAbonnement(idAbonnement);

    }
    @Operation(description="ceci pour la supprission d'un abonnement")
    @DeleteMapping("/deletAbonnement/{idA}")
    public   void deletAbonnement(@PathVariable("idA")Integer idAbonnement){
    iserviceAnnonce.deletAbonnement(idAbonnement);
    }

  /*  public void envoyerEmailAuxAbonnes(AnnonceMobilte annonce) {
        // Récupération de la catégorie de la nouvelle annonce
        CategorieMobilite categorie = annonce.getCategorie();

        // Récupération de tous les abonnements actifs pour cette catégorie
        List<Abonnement> abonnements = iserviceAnnonce.getAbonnementsActifs(categorie);

        // Envoi d'un e-mail à chaque utilisateur abonné
        for (Abonnement abonnement : abonnements) {
            User utilisateur = abonnement.getUser();
            String sujet = "Nouvelle annonce dans la catégorie " + categorie;
            String message = "Une nouvelle annonce a été publiée dans la catégorie " + categorie + ".\n\n" +
                    "Titre de l'annonce : " + annonce.getTitre() + "\n" +
                    "Description : " + annonce.getDescription_mobilite() + "\n" +
                    "Date de publication : " + annonce.getDatePublicationn() + "\n" +
                    "Lieu : " + annonce.getLieu() + "\n\n" +
                    "Vous pouvez consulter cette annonce en vous connectant à notre site.";

            emailService.sendSimpleMail(utilisateur.getEmail(), sujet, message);
        }
    }

   */
    @PostMapping ("/envoyerEmailPourNouvelleAnnonce/{categorie}/{sujet}/{message}")
    public String envoyerEmailPourNouvelleAnnonce(@PathVariable CategorieMobilite categorie ,@PathVariable String sujet,@PathVariable  String message ){
        // Récupérer la liste des utilisateurs ayant un abonnement actif pour la catégorie donnée
      return iserviceAnnonce.envoyerEmailPourNouvelleAnnonce(categorie,sujet,message);
        }



    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody String email, @RequestBody String subject, @RequestBody String message) {
        String status
                = iserviceAnnonce.sendSimpleMail(email, subject, message);

        return status;
    }
}






