package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Services.IserviceAnnonce;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerAnnonce {
    private final IserviceAnnonce iserviceAnnonce;


    @PostMapping("/addAnnonceMobilte")
    public AnnonceMobilte ajouterAnnonce(@RequestBody AnnonceMobilte annonce){
        return iserviceAnnonce.ajouterAnnonce(annonce);}




    @GetMapping("/GetAnnonceMobilte")
    public List<AnnonceMobilte> afficherAnnonces(){

        return  iserviceAnnonce.afficherAnnonces();}



    @GetMapping("/GetAnnonceMobiltebyId/{id}")
    public AnnonceMobilte afficherAnnonceavecid(@PathVariable("id") Integer id_Annonce){
        return  iserviceAnnonce.afficherAnnonceavecid(id_Annonce);
    }



    @PostMapping("/UpdateAnnonceMobiltebyId/{id}")
    public AnnonceMobilte modifierAnnonce(@PathVariable("id")Integer id_Annonce, AnnonceMobilte annonceModifiee) {
        return  iserviceAnnonce.modifierAnnonce(id_Annonce,annonceModifiee);

    }

    @DeleteMapping("/Delete annoonce/{id}")
    public void supprimerAnnonceMobilte(@PathVariable("id") Integer id_Annonce){
        iserviceAnnonce.supprimerAnnonceMobilte(id_Annonce);
    }
    /**********Hebergement*************************************************************************/




    @PostMapping("/addAnnoncehebergement")
    public AnnonceHeberge ajouterAnnonceH(@RequestBody AnnonceHeberge anhebergement){
        return iserviceAnnonce.ajouterAnnonceH(anhebergement);}




    @GetMapping("/Get_Annonce_hebergement")
    public List<AnnonceHeberge> afficherAnnonceH(){

        return  iserviceAnnonce.afficherAnnonceH();
    }



    @GetMapping("/Get_Annonce_hebergement_byId/{id}")
    public AnnonceHeberge afficherAnHebergementeavecid(@PathVariable("id") Integer id_AnnHeb){
        return  iserviceAnnonce.afficherAnHebergementeavecid(id_AnnHeb);
    }



    @PostMapping("/Update_AnnonceHebergement/{id}")
    public AnnonceHeberge modifierAnnonceHeb(@PathVariable("id")Integer id_AnnHeb, AnnonceHeberge annonceHmodifier) {
        return  iserviceAnnonce.modifierAnnonceHeb(id_AnnHeb,annonceHmodifier);

    }

    @DeleteMapping("/Delete annoonce_hebergement/{id}")
    public void supprimerAnnoncehebergement(@PathVariable("id") Integer id_AnnHeb){
        iserviceAnnonce.supprimerAnnoncehebergement(id_AnnHeb);
    }
    /**********RechercheControlller*****************/

    @GetMapping("/annonces")
    public List<AnnonceMobilte> chercherAnnoncesParTitre(@RequestParam("titre") String titre) {
        return iserviceAnnonce.chercherAnnoncesParTitre(titre);
    }

    @GetMapping("/afficherAnnonceParTitre")
    public void afficherAnnonceParTitre(@RequestParam("titre")String titre){
        iserviceAnnonce.afficherAnnonceParTitre(titre);
    }





}
