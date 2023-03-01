package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnonceMobilte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Annonce;
    private String titre;
    private String description_mobilite ;
    private Integer NombreDePlace;

    private LocalDate  datePublicationn ;
    private String photo ;
    @Temporal(TemporalType.DATE)
    private Date dateLimiteInsription;
    private String lieu  ;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private CategorieMobilite categorie;
    private  Integer LoveReact;
    private  Integer Signale;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private DetailMobilte details;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<FavorisMobile> favorisMobiles;

    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private  University university;

    @OneToMany(mappedBy = "annonceMobilte")
    private List<Abonnement> abonnements;

    @OneToMany(mappedBy = "annonceMobilte",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })


    private List<Candidacy> candidacies ;








}
