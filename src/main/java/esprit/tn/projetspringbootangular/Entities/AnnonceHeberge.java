package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
    private String title;
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date datePub ;
    private String image ;
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

