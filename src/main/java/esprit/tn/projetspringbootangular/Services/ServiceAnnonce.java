package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.AnnonceHeberge;
import esprit.tn.projetspringbootangular.Entities.AnnonceMobilte;
import esprit.tn.projetspringbootangular.Repository.HebergementRepository;
import esprit.tn.projetspringbootangular.Repository.MobilteRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceAnnonce implements IserviceAnnonce {
    private  final MobilteRepository mobilteRepository;
    private  final HebergementRepository hebergementRepository;

    private  final UserRepository userRepository;
    /*******************************annonceMobilte*****************************/

    @Override
    public AnnonceMobilte ajouterAnnonce(AnnonceMobilte annonce) {

        return mobilteRepository.save(annonce);





    }





    @Override
    public List<AnnonceMobilte> afficherAnnonces() {
        List<AnnonceMobilte> annonce = new ArrayList<>();
        mobilteRepository.findAll().forEach(annonce::add);
        return annonce;
    }

    @Override
    public AnnonceMobilte afficherAnnonceavecid(Integer id_Annonce) {
        return mobilteRepository.findById(id_Annonce).orElse(null);
    }

    @Override
    public AnnonceMobilte modifierAnnonce(Integer id_Annonce, AnnonceMobilte annonceModifiee) {
        AnnonceMobilte annonce = mobilteRepository.findById(id_Annonce).orElse(null);
        annonce.setId_Annonce(annonceModifiee.getId_Annonce());
        annonce.setDescription_mobilite(annonceModifiee.getDescription_mobilite());
        annonce.setDatePublicationn(annonceModifiee.getDatePublicationn());
        annonce.setPhoto(annonceModifiee.getPhoto());
        annonce.setDateLimiteInsription(annonceModifiee.getDateLimiteInsription());
        annonce.setLieu(annonceModifiee.getLieu());
        annonce.setState(annonceModifiee.getState());
        annonce.setCategorie(annonceModifiee.getCategorie());
        annonce.setDetails(annonceModifiee.getDetails());
        return mobilteRepository.save(annonce);
    }

    @Override
    public void supprimerAnnonceMobilte(Integer id_Annonce) {
        mobilteRepository.deleteById(id_Annonce);
    }
    /**********annonnce hebergement********************************************************************************/



    @Override
    public AnnonceHeberge ajouterAnnonceH(AnnonceHeberge anhebergement) {
        return hebergementRepository.save(anhebergement);
    }

    @Override
    public List<AnnonceHeberge> afficherAnnonceH() {
        List<AnnonceHeberge> annonceHeberges = new ArrayList<>();
        hebergementRepository.findAll().forEach(annonceHeberges::add);
        return annonceHeberges;
    }

    @Override
    public AnnonceHeberge afficherAnHebergementeavecid(Integer id_AnnHeb) {
        return hebergementRepository.findById(id_AnnHeb).orElse(null);
    }

    @Override
    public AnnonceHeberge modifierAnnonceHeb(Integer id_AnnHeb, AnnonceHeberge annonceHmodifier) {
        AnnonceHeberge annonceHeberge = hebergementRepository.findById(id_AnnHeb).orElse(null);
        annonceHeberge.setId_AnnHeb(annonceHmodifier.getId_AnnHeb());
        annonceHeberge.setAdresse(annonceHmodifier.getAdresse());
        annonceHeberge.setDatePub(annonceHmodifier.getDatePub());
        annonceHeberge.setDescription(annonceHmodifier.getDescription());
        annonceHeberge.setDetailHeberge(annonceHmodifier.getDetailHeberge());
        annonceHeberge.setImage(annonceHmodifier.getImage());
        annonceHeberge.setTitle(annonceHmodifier.getTitle());
        annonceHeberge.setAdresse(annonceHmodifier.getAdresse());
        annonceHeberge.setType(annonceHmodifier.getType());
        return  hebergementRepository.save(annonceHeberge);
    }

    @Override
    public void supprimerAnnoncehebergement(Integer id_AnnHeb) {
        hebergementRepository.deleteById(id_AnnHeb);   }




    /*******Recherche******/
    @Override
    public List<AnnonceMobilte> chercherAnnoncesParTitre(String titre) {
        return   mobilteRepository.findAnnonceMobilteByTitreIgnoreCase("titre de l'annonce" + titre);
    }




    @Override
    public void afficherAnnonceParTitre(String titre) {
        List<AnnonceMobilte> annoncesRecherchees = mobilteRepository.findAnnonceMobilteByTitreIgnoreCase(titre);
        if (!annoncesRecherchees.isEmpty()) {
            AnnonceMobilte annonce = annoncesRecherchees.get(0);
            annonce.getTitre()  ;
            annonce.getDescription_mobilite();
            annonce.getCategorie();
            annonce.getDateLimiteInsription();
            annonce.getLieu();
            annonce.getPhoto();
            annonce.getState();


            annonce.getDetails();

            // Ajoutez d'autres propriétés que vous souhaitez afficher
        } else {
            System.out.println("Aucune annonce trouvée avec le titre : " + titre);
        }


    }}
