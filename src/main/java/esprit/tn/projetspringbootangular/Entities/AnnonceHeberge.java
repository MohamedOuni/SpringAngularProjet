package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnonceHeberge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_AnnHeb ;
    @NotBlank(message = "Le titre ne peut pas être vide")
    @Size(max = 50, message = "Le titre ne peut pas dépasser {max} caractères")
    private String title;
    @NotBlank(message = "La description ne peut pas être vide")
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date datePub ;

    @Lob
    private byte[]  image ;
    private String adresse ;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private DetailHebergement detailHeberge;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnore
    private List<FavorisHebergement> favorisHebergements;

    @ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    private  University university;

    @ManyToOne
    private User user;
}

