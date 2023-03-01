package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.*;

import esprit.tn.projetspringbootangular.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceAnnonce implements IserviceAnnonce {
    /* private final Logger logger= LogManager.getLogger(ServiceAnnonce.class);*/
    private final MobilteRepository mobilteRepository;
    private final HebergementRepository hebergementRepository;
    private final FavorisHebRepository favorisHebRepository;
    private final CondidacyRepository condidacyRepository;
    private final FavorisMobilteRepository favorisMobilteRepository;
    private final UserRepository userRepository;
    private final UniversityRepository universityRepository;
    private final AbonnementRepository abonnementRepository;

    private final JavaMailSender javaMailSender;

    /*******************************annonceMobilte**/


    @Override
    public void ajouterAnnonce(AnnonceMobilte annonce) {

        mobilteRepository.save(annonce);


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
        return hebergementRepository.save(annonceHeberge);
    }

    @Override
    public void supprimerAnnoncehebergement(Integer id_AnnHeb) {
        hebergementRepository.deleteById(id_AnnHeb);
    }


    /*******Recherche****************************************************************************************/
    @Override
    public List<AnnonceMobilte> chercherAnnoncesParTitre(String titre) {
        return mobilteRepository.findAnnonceMobilteByTitreIgnoreCase("titre de l'annonce" + titre);
    }


    @Override
    public void afficherAnnonceParTitre(String titre) {
        List<AnnonceMobilte> annoncesRecherchees = mobilteRepository.findAnnonceMobilteByTitreIgnoreCase(titre);
        if (!annoncesRecherchees.isEmpty()) {
            AnnonceMobilte annonce = annoncesRecherchees.get(0);
            annonce.getTitre();
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


    }

    @Override
    public List<AnnonceMobilte> afficherAnnonceParLieu(String lieu) {
        return mobilteRepository.findAnnonceMobilteByLieuIgnoreCase(lieu);


    }


    @Override
    public List<AnnonceMobilte> findByCategorie(CategorieMobilite categorie) {
        return mobilteRepository.findByCategorie(categorie);
    }


    @Override
    public List<AnnonceMobilte> getAnnoncesFiltrees(String filter) {
        LocalDate datePublicationn;
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

        return mobilteRepository.findAnnonceMobilteByDatePublicationnAfter(datePublicationn);
    }

    @Override
    public void delete(AnnonceMobilte annonceMobilte) {
        mobilteRepository.delete(annonceMobilte);
    }


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
        }
    }

    /***********************************lesaffectation_de _lannonce mobilté******************************************************/
    @Override
    public void affecterAnnonceMobiliteAUniversity(Integer id_Annonce, Integer idUniversity) {
        AnnonceMobilte annonce = mobilteRepository.findById(id_Annonce).orElse(null);
        University university = universityRepository.findById(idUniversity).orElse(null);
        annonce.setUniversity(university);
        mobilteRepository.save(annonce);

    }


    /**************************************Abonnnementservie************************************************/
    @Override
    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
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
        return abonnementRepository.findById(idAbonnement).orElse(null);
    }

    @Override
    public void deletAbonnement(Integer idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);
    }

    @Override
    public void affecterUserToAbonnement(Integer id_user, Integer idAbonnement) {
        Abonnement abonnement = abonnementRepository.findById(idAbonnement).orElse(null);
        User userList = userRepository.findById(id_user).orElse(null);

        abonnement.setUser(userList);
        abonnementRepository.save(abonnement);

    }

    @Override
    public void affecterAnnonceToAbonnement(Integer id_Annonce, Integer idAbonnement) {
        Abonnement abonnement = abonnementRepository.findById(idAbonnement).orElse(null);
        AnnonceMobilte annonceMobilte = mobilteRepository.findById(id_Annonce).orElse(null);

        abonnement.setAnnonce(annonceMobilte);
        abonnementRepository.save(abonnement);

    }


    /******Lorsqu'une nouvelle annonce est ajoutée, vous pouvez récupérer la liste des abonnements actifs pour cette catégorie et envoyer une notification par e-mail à chaque abonné.***/
    @Override
    public List<Abonnement> AFFICHERAbonnementsActifs(CategorieMobilite categorie) {
        return abonnementRepository.findAbonnementsActifsByCategorie(categorie);
    }


    @Override
    public FavorisMobile ajouterFavoris(FavorisMobile favorisMobile) {
        return favorisMobilteRepository.save(favorisMobile);
    }

    @Override
    public List<FavorisMobile> getFavorisMobiles() {

        List<FavorisMobile> favorisMobiles = new ArrayList<>();
        favorisMobilteRepository.findAll().forEach(favorisMobiles::add);
        return favorisMobiles;
    }


    @Override
    public void ajouterAnnonceAuxFavoris(Integer id_Annonce, Integer id_user) {
        AnnonceMobilte annonce = mobilteRepository.findById(id_Annonce).orElse(null);
        User user = new User();
        user.setId_user(id_user);
        FavorisMobile favoris = favorisMobilteRepository.findByUserAndAnnonceMobiltes(user, annonce);
        if (favoris == null) {
            favoris = new FavorisMobile();
            favoris.setUser(user);
            favoris.setAnnonceMobiltes(new ArrayList<AnnonceMobilte>());
        }
        favoris.getAnnonceMobiltes().add(annonce);
        favorisMobilteRepository.save(favoris);
    }


    @Scheduled(fixedRate = 86400000) //24 heures
    public void verifierAnnonces() {
        List<AnnonceMobilte> annonces = mobilteRepository.findAll();

        for (AnnonceMobilte annonce : annonces) {
            if (annonce.getState() == State.ACTIF) {
                int nbSignalements = annonce.getSignale();
                int nbLikes = annonce.getLoveReact();
                LocalDate datePublication = annonce.getDatePublicationn();
                LocalDate today = LocalDate.now();

                if (nbSignalements > 50 && nbSignalements < nbLikes && today.isAfter(datePublication.plusDays(5))) {
                    annonce.setState(State.INACTIF);
                    mobilteRepository.save(annonce);
                }

                if (nbSignalements > 100 && nbLikes == 0 && today.isAfter(datePublication.plusDays(1))) {
                    mobilteRepository.delete(annonce);
                    String toEmail = "nouha.kouki@esprit.tn";
                    String Subject = "Vérifiez votre annonce";
                    String body = "Bonjour,\n\nNous avons supprimé votre annonce \"" + annonce.getTitre() +
                            "\" car elle a été signalée plus de 100 fois et n'a reçu aucun like. Veuillez vérifier que votre annonce respecte bien nos conditions d'utilisation.\n\nCordialement,\nL'équipe de notre application.";


                    EmailServiceImpl emailService = null;
                    emailService.sendSimpleEmail(toEmail, body,
                            Subject);
                }

            }
        }
    }

    @Override
    public Map<String, Map<String, Integer>> getAnnoncesStatistiques(LocalDate dateDebut, LocalDate dateFin) {

        List<AnnonceMobilte> annonces = mobilteRepository.findByDatePublicationnBetween(dateDebut, dateFin);

        Map<String, Map<String, Integer>> statistiques = new HashMap<>();

        for (AnnonceMobilte annonce : annonces) {

            Integer totalLikes = annonce.getLoveReact();
            Integer totalSignales = annonce.getSignale();


            String categorie = annonce.getCategorie().name();
            Map<String, Integer> categorieStatistiques = statistiques.getOrDefault(categorie, new HashMap<>());

            categorieStatistiques.put("totalLikes", categorieStatistiques.getOrDefault("totalLikes", 0) + totalLikes);
            categorieStatistiques.put("totalSignales", categorieStatistiques.getOrDefault("totalSignales", 0) + totalSignales);

            statistiques.put(categorie, categorieStatistiques);
        }

        return statistiques;
    }


    @Override

    public List<Candidacy> getCandidaciesByAnnonceId(Integer id_Annonce) {
        return condidacyRepository.findCandidaciesByAnnonceId(id_Annonce);
    }


    @Override
    public void affecterCondidatureToAnnonce(Integer id, Integer id_Annonce) {
        Candidacy candidacy = condidacyRepository.findById(id).orElse(null);
        AnnonceMobilte annonceMobilte = mobilteRepository.findById(id_Annonce).orElse(null);

        candidacy.setAnnonceMobilte(annonceMobilte);
        condidacyRepository.save(candidacy);

    }


    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // rayon de la terre en kilomètres
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;
        return distance;
    }


    @Override
    public double calculateScore(Integer id_Annonce) {
        double score = 0;


        AnnonceMobilte annonce = mobilteRepository.findById(id_Annonce).orElse(null);
        if (annonce.getDescription_mobilite() != null) {
            score += 2;
        }
        double distanceToTunisia = calculateDistance(annonce.getDetails().getLatitude(), annonce.getDetails().getLongitude(), 33.886917, 9.537499);
        if (distanceToTunisia <1900) {
            score += 1;
        }
        if (annonce.getNombreDePlace() > 2) {
            score += 1;
        }
        if (annonce.getDetails().getAvantages() !=null) {
            score += 2;
        }

        int numCandidates = annonce.getCandidacies().size();
        if (numCandidates >100) {
            score += 2;
        }







            int loveReact = annonce.getLoveReact() != null ? annonce.getLoveReact() : 0;
            int signale = annonce.getSignale() != null ? annonce.getSignale() : 0;
            score += (loveReact - signale) * 0.1;


       /* score -= distanceToTunisia * 0.01; // ala kol km yna9s le score b 0,01*/
        return score;
    }



    @Override
    public void notifierAbonnes(CategorieMobilite categorie, String message) {
        List<Abonnement> abonnements = abonnementRepository.findByCategorieAndActifIsTrue(categorie);
        for (Abonnement abonnement : abonnements) {
            sendSimpleEmail(abonnement.getEmail(), message, "Nouvelle annonce pour la catégorie " + categorie);
        }
    }

    public void sendSimpleEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nouhe.kouki.1999@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("Mail Send...");
    }
}



