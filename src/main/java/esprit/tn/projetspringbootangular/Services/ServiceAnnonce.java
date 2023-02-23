package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.*;
import esprit.tn.projetspringbootangular.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceAnnonce implements IserviceAnnonce {
    private  final MobilteRepository mobilteRepository;
    private  final HebergementRepository hebergementRepository;

    private  final UserRepository userRepository;
    private  final UniversityRepository universityRepository;
    private  final AbonnementRepository abonnementRepository;
    private  final JavaMailSender javaMailSender;
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


    } @Override
    public void afficherAnnonceParLieu(String lieu) {
        List<AnnonceMobilte> annonces = mobilteRepository.findAnnonceMobilteByTitreIgnoreCase(lieu);
        if (!annonces.isEmpty()) {
            AnnonceMobilte annonce = annonces.get(0);
            annonce.getTitre();
            annonce.getDescription_mobilite();
            annonce.getCategorie();
            annonce.getDateLimiteInsription();
            annonce.getPhoto();
            annonce.getState();
            annonce.getDetails();

            // Ajoutez d'autres propriétés que vous souhaitez afficher
        } else {
            System.out.println("Aucune annonce trouvée avec le LIEU : " + lieu);
        }

    }


    @Override
    public List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie) {
        return mobilteRepository.findByCategorie(categorie);
    }


    @Override
    public List<AnnonceMobilte> getAnnoncesFiltrees(String filter) {
        LocalDate  datePublicationn;
        switch (filter) {
            case "last24hours":
                datePublicationn = LocalDate.now().minusDays(1);
                break;
            case "last3days":
                datePublicationn = LocalDate.now().minusDays(3);
                break;
            case "last7days":
                datePublicationn = LocalDate.now().minusDays(7);
                break;
            case "thisMonth":
                datePublicationn = LocalDate.now().withDayOfMonth(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid filter: " + filter);
        }

        return mobilteRepository.findAnnonceMobilteByDatePublicationnAfter( datePublicationn);
    }
    @Override
    public void delete(AnnonceMobilte annonceMobilte) {
        mobilteRepository.delete(annonceMobilte);}


    @Override
    public List<AnnonceMobilte> findByDateLimiteInscription(LocalDate dateLimiteInscription) {
        return mobilteRepository.findByDateLimiteInscription(dateLimiteInscription);
    }
    @Override
    @Scheduled(cron = "0 0 0 * * *") // chaque jour à minuit
    public void verifierDateLimiteInscription() {
        LocalDateTime maintenant = LocalDateTime.now();
        LocalDate aujourdHui = maintenant.toLocalDate();
        LocalTime minuit = LocalTime.MIDNIGHT;
        LocalDateTime minuitAujourdhui = LocalDateTime.of(aujourdHui, minuit);
        List<AnnonceMobilte> annonces = mobilteRepository.findByDateLimiteInscription(aujourdHui);
        for (AnnonceMobilte annonce : annonces) {
            annonce.setState(State.INACTIF);
            mobilteRepository.save(annonce);
            // supprimer l'annonce si la date limite est atteinte
            if (annonce.getDateLimiteInsription().equals(aujourdHui) && maintenant.isAfter(minuitAujourdhui)) {
                mobilteRepository.delete(annonce);
            }
        }}
/***********************************lesaffectation_de _lannonce mobilté******************************************************/
        @Override
        public void affecterAnnonceMobiliteAUniversity(Integer id_Annonce, Integer idUniversity) {
            AnnonceMobilte  annonce = mobilteRepository.findById(id_Annonce).orElse(null);
            University  university = universityRepository.findById(idUniversity).orElse(null);
           annonce.setUniversity(university);


}

       /*****ajouter annonce et affecter a une universite*********/

       @Override
       public AnnonceMobilte ajouterAnnonceMobilteEtAffecterToUniversity(AnnonceMobilte annonceMobilte, Integer idUniversity) {
           University university = universityRepository.findById(idUniversity).orElse(null);
           university.getAnMobiltes().add(annonceMobilte); //ajouter et afficher annonce
           annonceMobilte.setUniversity(university);

           return mobilteRepository.save(annonceMobilte);
}
/****** affichage de la listedes annonce d'une univerite******/

@Override
public List<AnnonceMobilte> AfficherListeAnnonceParUniversite(Integer idUniversity) {
    University university = universityRepository.findById(idUniversity).orElse(null);
    return university.getAnMobiltes();

}

    @Override //ajouter une unviersité  et affecter a 2 equipe les 2 id doivent etre different

        public void ajouterDeuxAnnonceEtAffecterAUniversity(Integer idUniversity, AnnonceMobilte annonceMobilte, AnnonceHeberge annonceHeberge) {
            University university = universityRepository.findById(idUniversity)
                    .orElseThrow(() -> new EntityNotFoundException("University not found"));
            mobilteRepository.save(annonceMobilte).setUniversity(university);
            hebergementRepository.save(annonceHeberge).setUniversity(university);
    }


/**************************************Abonnnementservie************************************************/
@Override
public Abonnement createAbonnement(Abonnement abonnement) {
    return  abonnementRepository.save(abonnement);
}
    @Override
    public Abonnement UpdateAbonnement(Abonnement abonnement, Integer idAbonnement) {
        Abonnement abonnement1 = abonnementRepository.findById(idAbonnement).orElse(null);
        abonnement1.setEmail(abonnement.getEmail());
        abonnement1.setCategorie(abonnement.getCategorie());
        abonnement1.setActif(abonnement.isActif());
        return abonnementRepository.save(abonnement);
    }

@Override
public Abonnement GetAbonnement(Integer idAbonnement) {
    return  abonnementRepository.findById(idAbonnement).orElse(null);
}
    @Override
    public   void deletAbonnement(Integer idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);
    }

/******Lorsqu'une nouvelle annonce est ajoutée, vous pouvez récupérer la liste des abonnements actifs pour cette catégorie et envoyer une notification par e-mail à chaque abonné.***/
@Override
public List<Abonnement> getAbonnementsActifs(CategorieMobilite categorie) {
    return abonnementRepository.findAbonnementByCategorieAndActifTrue(categorie);}




    @Override
    public String envoyerEmailPourNouvelleAnnonce(CategorieMobilite categorie, String sujet, String message) {
        // Récupérer la liste des utilisateurs ayant un abonnement actif pour la catégorie donnée
        List<Abonnement> abonnementsActifs = abonnementRepository.findAbonnementByCategorieAndActifTrue(categorie);

        // Envoyer un e-mail à chaque utilisateur ayant un abonnement actif
        for (Abonnement abonnement : abonnementsActifs) {
            User utilisateur = abonnement.getUser();
            String mailAbonnement = utilisateur.getEmail();
            sendSimpleMail(mailAbonnement  , sujet, message);
        }
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setSubject(sujet);
            mailMessage.setText(message);
            javaMailSender.send(mailMessage);
            return "Email envoyé avec succès!";
        } catch (Exception ex) {
            return "Erreur lors de l'envoi de l'e-mail: " + ex.getMessage();
        }
    }



    @Override
    public String sendSimpleMail(String email, String subject, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);
            javaMailSender.send(mailMessage);
            return "Email envoyé avec succès!";
        } catch (Exception ex) {
            return "Erreur lors de l'envoi de l'e-mail: " + ex.getMessage();
        }
    }
    }