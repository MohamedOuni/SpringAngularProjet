package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAbonnement;
    private String email;
    @Enumerated(EnumType.STRING)
    private CategorieMobilite categorie;
    private boolean actif;//Lorsqu'une nouvelle annonce est ajoutée, vous pouvez récupérer la liste des abonnements actifs pour cette catégorie et envoyer une notification par e-mail à chaque abonné.//
    @ManyToOne
    private AnnonceMobilte annonce;



    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "annonce")
    private List<Abonnement> abonnements;
}
