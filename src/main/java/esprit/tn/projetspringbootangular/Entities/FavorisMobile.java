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
public class FavorisMobile implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_fav ;

    @ManyToMany(mappedBy ="favorisMobiles",cascade = {CascadeType.PERSIST,CascadeType.REMOVE })
    @JsonIgnore
    private List<AnnonceMobilte> annonceMobiltes ;
    @ManyToOne
    User user;


}
