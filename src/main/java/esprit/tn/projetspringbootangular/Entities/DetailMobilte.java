package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailMobilte implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_det;
    private Double  longitude ;
    private Double latitude ;
    private String avantages ;
    private String  plus_details ;
    private String qualification_demande ;
    private String  langue ;
    private String lieuDepart;
    private String lieuArrivee;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Temporal(TemporalType.DATE)
    private Date dateArrive;
    private Integer contact ;


    @OneToOne(mappedBy="details",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    @JsonIgnore
    private AnnonceMobilte anMobilte;

}


