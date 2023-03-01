package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailHebergement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_detail;
    private String Region;
    private String localite;
    private String avantages;
    private Double latitude;
    private Double longtitude;
    private String avis_aide;
    private String contact;



    @OneToOne(mappedBy="detailHeberge",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    @JsonIgnore
    private AnnonceHeberge annonceHeberge;

}
