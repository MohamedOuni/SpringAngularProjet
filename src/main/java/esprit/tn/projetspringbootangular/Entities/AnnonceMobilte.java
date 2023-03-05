package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "Le titre ne peut pas être vide")
    @Size(max = 50, message = "Le titre ne peut pas dépasser {max} caractères")
    private String titre;
    @NotBlank(message = "La description ne peut pas être vide")
    private String description_mobilite ;

    @NotNull(message = "Le nombre de places ne peut pas être vide")
    @Min(value = 1, message = "Le nombre de places doit être au moins {value}")
    private Integer NombreDePlace;

    private LocalDate  datePublicationn ;

    private String photo;

    @Temporal(TemporalType.DATE)
    private Date dateLimiteInsription;
    private String lieu  ;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private CategorieMobilite categorie;
    private  Integer LoveReact;
    private  Integer Signale;
    private  Integer  sentiment_scor;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private DetailMobilte details;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<FavorisMobile> favorisMobiles;




    @OneToMany(mappedBy = "annonceMobilte")
    private List<Abonnement> abonnements;

    @OneToMany(mappedBy = "annonceMobilte",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })


    private List<Candidacy> candidacies ;

    @OneToMany(mappedBy = "annonce",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private  List<CommentAnnonce>commentAnnonces;

@ManyToOne
    User user;






}
