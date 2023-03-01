package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class FavorisHebergement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_favHeb;
    @ManyToMany(mappedBy ="favorisHebergements",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    @JsonIgnore
    private List<AnnonceHeberge> annonceHeberges;
    @ManyToOne
    User user;
}
